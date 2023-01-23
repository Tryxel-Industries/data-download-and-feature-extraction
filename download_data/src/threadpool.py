from tqdm import tqdm
from concurrent.futures import ThreadPoolExecutor, as_completed
import requests
import pandas as pd
from download import crawl_news_article
from util.util import create_dir, Config
import json
def init_config():
    json_object = json.load(open("src/config.json"))

    config = Config(json_object["dataset_dir"], json_object["dump_location"], json_object["tweet_keys_file"],
                    int(json_object["num_process"]))

    data_choices = json_object["data_collection_choice"]
    data_features_to_collect = json_object["data_features_to_collect"]

    return config, data_choices, data_features_to_collect

def wrapper(url, pbar, error_links):
    result = crawl_news_article(url[0])
    pbar.update(1)
    if result is None:
        error_links.append(url[0])
    else:
        create_dir("{}/{}".format(save_dir, url[1]))
        json.dump(result,
            open("{}/{}/news content.json".format(save_dir, url[1]), "w", encoding="UTF-8"))

    return result

    
if __name__ == "__main__":


    config, data_choices, data_features_to_collect = init_config()
    choice = data_choices[0]
    articles = []
    links = (pd.read_csv("dataset_sources/politifact_fake.csv", keep_default_na=False)["news_url"]).to_list()#[:30]
    ids = (pd.read_csv("dataset_sources/politifact_fake.csv", keep_default_na=False)["id"]).to_list()#[:30]
    df = dict(zip(links, ids))
    # links = ["https://www.naturalnews.com/2023-01-22-climate-cult-no-more-breathing-co2-emissions.html"]
    create_dir(config.dump_location)
    create_dir("{}/{}".format(config.dump_location, choice["news_source"]))
    create_dir("{}/{}/{}".format(config.dump_location, choice["news_source"], choice["label"]))

    save_dir = "{}/{}/{}".format(config.dump_location, choice["news_source"], choice["label"])
    error_links=[]
    with tqdm(total=len(links)) as pbar:
        with ThreadPoolExecutor(max_workers=12) as ex:
            futures = {ex.submit(wrapper, url, pbar, error_links): url for url in zip(links, ids)}
            for future in as_completed(futures.keys()):
                result = future.result()

                articles.append(result)
    print(len(error_links))
    print(error_links)