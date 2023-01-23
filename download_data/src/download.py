import pandas as pd
import numpy as np
import json
import logging
import time
import typing
from util.Constants import ARCHIVE_EARLIEST
import requests
from tqdm import tqdm
from newspaper import Article, ArticleException
from newspaper import Config
from util.util import Config as cf, create_dir
import threading
def get_epoch_time(time_obj):
    if time_obj:
        return time_obj.timestamp()

    return None

def get_earliest_wayback_url(url: str) -> object:
    try:
        wayback_api_url= f"http://archive.org/wayback/available?url={url}{ARCHIVE_EARLIEST}"

        response = requests.get(wayback_api_url)
        response_json = json.loads(response.content)

        response_json = response_json["archived_snapshots"]
        if response_json:
            return response_json["closest"]["url"]

        return None
    except:
        return None

def crawl_news_article(url) -> "dict[str, any]":
    
    # news_article = crawl_link_article(url)
    news_article = None

    # If the news article could not be fetched from original website, fetch from archive if it exists.
    if news_article is None:
        # print(f"{threading.get_native_id()}: Trying wayback for link {url}")
        archive = get_earliest_wayback_url(url)
        if archive is not None:
            # print(f"Link {url} available on wayback!")
            news_article = crawl_link_article(archive)
        else:
            pass
            # print(f"Link {url} not available on wayback")
    return news_article

def crawl_link_article(url: str):
    user_agent = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:78.0) Gecko/20100101 Firefox/78.0'
    # url = "https://www.nrk.no/innlandet/flere-funksjonshemmede-foler-de-ikke-far-psykisk-helsehjelp-1.16253006"
    config = Config()
    config.browser_user_agent = user_agent
    config.request_timeout = 60

    def crawl(article:Article) -> bool:
        try:
            article.download()
            article.parse()
            return True
        except ArticleException as ex:
            # print(f"Error crawling link {url}")
            # logging.exception("Exception in getting data from url {}".format(url))
            pass
        return False

    try:
        article = None
        if "http" in url:
            try:
                article = Article(url, config=config)
                crawl(article)
                
            except:
                return None
        else:
            article = Article('http://' + url, config=config)
            if not crawl(article):
                article = Article('https://' + url, config=config)
                crawl(article)

        if not article.is_parsed:
            return None

        result_json = None
        visible_text = article.text
        top_image = article.top_image
        images = article.images
        keywords = article.keywords
        authors = article.authors
        canonical_link = article.canonical_link
        title = article.title
        meta_data = article.meta_data
        movies = article.movies
        publish_date = article.publish_date
        source = article.source_url
        summary = article.summary

        result_json = {'url': url, 'text': visible_text, 'images': list(images), 'top_img': top_image,
                       'keywords': keywords,
                       'authors': authors, 'canonical_link': canonical_link, 'title': title, 'meta_data': meta_data,
                       'movies': movies, 'publish_date': get_epoch_time(publish_date), 'source': source,
                       'summary': summary}
        # print(f"Successfully crawled {url}")
    except Exception as e:
        logging.exception("Exception in fetching article from URL : {}".format(url))

    return result_json

def save_articles(articles: "list[Article]", news_source, label, config: Config) -> bool:
    create_dir(config.dump_location)
    create_dir("{}/{}".format(config.dump_location, news_source))
    create_dir("{}/{}/{}".format(config.dump_location, news_source, label))

    save_dir = "{}/{}/{}".format(config.dump_location, news_source, label)

    for news in tqdm(articles):
        create_dir("{}/{}".format(save_dir, news.news_id))
        news_article = crawl_news_article(news.news_url)
        if news_article:
            json.dump(news_article,
                      open("{}/{}/news content.json".format(save_dir, news.news_id), "w", encoding="UTF-8"))





if __name__ == "__main__":
    
    user_agent = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:78.0) Gecko/20100101 Firefox/78.0'


    url = "http://www.opreminfo.com/2018/07/10/pope-says-that-the-rights-of-muslim-migrants-trump-any-safety-concerns-that-you-might-have-with-them-in-your-country/"

    config = Config()
    config.browser_user_agent = user_agent
    config.request_timeout = 30

    page = Article(url, config=config)
    crawl_news_article(url=url)
    # page.download()
    # page.parse()
    print(page)