from crawler import NewsCrawler
import threading
import queue
import pandas as pd
NUM_CRAWLERS = 8

if __name__ == "__main__":
    links_to_crawl = queue.Queue()
    url_lock = threading.Lock()
    links = (pd.read_csv("dataset_sources/politifact_fake.csv", keep_default_na=False)["news_url"]).to_list()
    list(map(links_to_crawl.put, links))
    have_visited = set()
    crawler_threads = []
    error_links = []

    for i in range(NUM_CRAWLERS):
        crawler = NewsCrawler(links_to_crawl=links_to_crawl, have_visited=have_visited, error_links=error_links, url_lock=url_lock)

        crawler.start()
        crawler_threads.append(crawler)
    
    for crawler in crawler_threads:
        crawler.join()