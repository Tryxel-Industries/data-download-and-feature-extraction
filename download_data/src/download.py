import pandas as pd
import numpy as np
import json
import logging
import time
import typing
from util.Constants import ARCHIVE_EARLIEST
import requests
from tqdm import tqdm
from newspaper import Article

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

def crawl_news_article(url):
    news_article = crawl_link_article(url)

    # If the news article could not be fetched from original website, fetch from archive if it exists.
    if news_article is None:
        archive = get_earliest_wayback_url(url)
        if archive is not None:
            news_article = crawl_link_article(archive)

    return news_article

def crawl_link_article(url: str):

    def crawl(article:Article) -> bool:
        try:
            article.download()
            time.sleep(2)
            article.parse()
            return True
        except:
            logging.exception("Exception in getting data from url {}".format(url))
        return False

    try:
        article = None
        if "http" in url:
            try:
                article = Article(url)
                crawl(article)
            except:
                return None
        else:
            article = Article('http://' + url)
            if not crawl(article):
                article = Article('https://' + url)
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
    except Exception as e:
        logging.exception("Exception in fetching article from URL : {}".format(url))

    return result_json


