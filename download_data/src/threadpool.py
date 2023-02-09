from tqdm import tqdm
from concurrent.futures import ThreadPoolExecutor, as_completed
import requests
import pandas as pd
from download import crawl_news_article
from util.util import create_dir, Config
import json
import argparse
import logging

def init_config():
    json_object = json.load(open("src/config.json"))

    config = Config(json_object["dataset_dir"], json_object["dump_location"], json_object["tweet_keys_file"],
                    int(json_object["num_process"]))

    data_choices = json_object["data_collection_choice"]
    data_features_to_collect = json_object["data_features_to_collect"]

    return config, data_choices, data_features_to_collect

def wrapper(url: str, pbar, error_links: list, save_dir: str, all_wayback: bool):
    result = crawl_news_article(url[0], all_wayback)
    pbar.update(1)
    if result is None:
        save_error_links([str([url[0]] + '\n')], mode='a')
        error_links.append(url[0])
    else:
        create_dir("{}/{}".format(save_dir, url[1]))
        json.dump(result,
            open("{}/{}/news content.json".format(save_dir, url[1]), mode="w", encoding="UTF-8"))

    return result

def deploy_crawlers(args):
    config, data_choices, data_features_to_collect = init_config()
    # 0 = politifact fake, 1 = politifact real
    choice = data_choices[1]
    print(choice)
    articles = []
    # Av en eller annen uforståelig grunn henger python requests library noen ganger. Tror det har å gjøre med user-agent.
    # Med wayback henger alltid på washingtonpost.com, uten henger alltid på nytimes.com. Sjekk download.log
    links = (pd.read_csv(f'dataset_sources/{choice["news_source"]}_{choice["label"]}.csv', keep_default_na=False)["news_url"]).to_list()#[482:]
    ids = (pd.read_csv(f'dataset_sources/{choice["news_source"]}_{choice["label"]}.csv', keep_default_na=False)["id"]).to_list()#[482:]

    create_dir(config.dump_location)
    create_dir("{}/{}".format(config.dump_location, choice["news_source"]))
    create_dir("{}/{}/{}".format(config.dump_location, choice["news_source"], choice["label"]))
    save_dir = "{}/{}/{}".format(config.dump_location, choice["news_source"], choice["label"])
    error_links=[]

    with tqdm(total=len(links)) as pbar:
        with ThreadPoolExecutor(max_workers=args.num_crawlers) as ex:
            futures = {ex.submit(wrapper, url, pbar, error_links, save_dir, args.all_wayback): url for url in zip(links, ids)}
            for future in as_completed(futures.keys()):
                result = future.result()
                articles.append(result)

    print(f"Links returning error: {len(error_links)}")
    # save_error_links(error_links)

def load_error_links(mode='w'):
    with open("logs/error_links.log", mode=mode) as f:
        return f.readlines()
def save_error_links(links: list, mode='w'):

    with open("logs/error_links.log", mode=mode) as f:
        for url in links:
            f.write(f"{url}\n")

def str_to_bool(x):
    '''Convert string to boolean'''
    return x.lower() in ['true', '1', 't', 'y', 'yes']



if __name__ == "__main__":

    logging.basicConfig(filename="logs/download.log", filemode="w", level=logging.DEBUG)
    parser = argparse.ArgumentParser("run main")

    parser.add_argument("-n", "--num_crawlers", type=int, default=1, help="Number of simultaneous crawlers to run")
    parser.add_argument("-w", "--all_wayback", type=str_to_bool, default=False, help="Whether to put all links through internet archive's wayback machine first, instead of using it as a fallback")
    
    args = parser.parse_args()
    deploy_crawlers(args)