import threading
import queue
import time
from download import crawl_news_article
from newspaper import ArticleException, Article
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
