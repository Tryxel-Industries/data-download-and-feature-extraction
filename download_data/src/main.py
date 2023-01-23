from crawler import NewsCrawler
from download import save_articles
import threading
import queue
import pandas as pd
from newspaper import Article
import json
from util.util import Config
NUM_CRAWLERS = 1

def init_config():
    json_object = json.load(open("src/config.json"))

    config = Config(json_object["dataset_dir"], json_object["dump_location"], json_object["tweet_keys_file"],
                    int(json_object["num_process"]))

    data_choices = json_object["data_collection_choice"]
    data_features_to_collect = json_object["data_features_to_collect"]

    return config, data_choices, data_features_to_collect

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