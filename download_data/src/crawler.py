import threading
import queue
import pandas as pd
from download import crawl_news_article, save_articles
from newspaper import ArticleException, Article
from threadpool import init_config
NUM_CRAWLERS = 1


class NewsCrawler(threading.Thread):
    def __init__(self, links_to_crawl:queue.Queue, have_visited:set, error_links: list, url_lock: threading.Lock, article_contents: "list[Article]"):
        threading.Thread.__init__(self)
        print(f"Web Crawler worker {threading.current_thread()} has Started")
        self.links_to_crawl = links_to_crawl
        self.have_visited = have_visited
        self.error_links = error_links
        self.url_lock = url_lock
        self.article_contents: article_contents

    def run(self):
        while True:
            self.url_lock.acquire()
            link = self.links_to_crawl.get()
            self.url_lock.release()
            print(f"Crawler {self.native_id} crawling link {link}")
            if link is None:
                break

            if link in self.have_visited:
                print(f"link: {link} in visited")
                break
            try:
                article = crawl_news_article(link)
                if article is None:
                    self.error_links.append(link)
                else:
                    self.article_contents.append(article)
                self.have_visited.add(article)
            except ArticleException:
                print(f"Error when downloading article. link:{link}")
                self.error_links.append(link)
            except:
                self.error_links.append(link)
            finally:
                self.links_to_crawl.task_done()

if __name__ == "__main__":
    links_to_crawl = queue.Queue()
    url_lock = threading.Lock()
    links = (pd.read_csv("dataset_sources/politifact_fake.csv", keep_default_na=False)["news_url"]).to_list()
    list(map(links_to_crawl.put, links))
    have_visited = set()
    crawler_threads = []
    error_links = []
    article_contents: "list[Article]" = []




    config, data_choices, data_features_to_collect = init_config()
    # Crawler hver source fil etter hverandre
    for choice in data_choices:
        print(("Crawling links from {}. Label: {}").format(choice["news_source"], choice["label"]))
        for i in range(NUM_CRAWLERS):
            crawler = NewsCrawler(links_to_crawl=links_to_crawl, have_visited=have_visited, error_links=error_links, url_lock=url_lock, article_contents=article_contents)

            crawler.start()
            crawler_threads.append(crawler)
        
        for crawler in crawler_threads:
            crawler.join()

        save_articles(articles=article_contents, news_source=choice["news_source"], label=choice["label"], config=config)