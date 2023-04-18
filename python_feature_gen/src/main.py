import json
import os
from typing import List

import torch
from tqdm import tqdm
from transformers import BertConfig, BertModel, BertTokenizerFast
import numpy as np

out_dir_base_path = "./../data_out/"

embedding_fn_pattern = "embedding_{}.json"


class NewsArticle:
    def __init__(self, id: int, sentences: List[str]):
        self.sentences = sentences
        self.id = id


class EmbeddedArticle:
    def __init__(self, newsArticle: NewsArticle, embedding: List[float]):
        self.embedding = embedding
        self.sentences = newsArticle.sentences
        self.id = newsArticle.id

    def as_json_dict(self):
        return {
            "id": self.id,
            "sentences": self.sentences,
            "embedding": self.embedding,
        }


def scan_for_untransformed_sentence_files():
    ret = []

    for dir in os.listdir(out_dir_base_path):
        dir_path = os.path.join(out_dir_base_path, dir)
        if os.path.isdir(dir_path):
            ssplit_name = f"sentence_split_{dir}.json"
            has_sspilt = False

            embed_name = embedding_fn_pattern.format(dir)
            has_embed = False
            for filename in os.listdir(dir_path):
                if filename == ssplit_name:
                    has_sspilt = True
                if filename == embed_name:
                    has_embed = True
            if has_sspilt and not has_embed:
                ret.append((os.path.join(dir_path, ssplit_name), os.path.join(dir_path, embed_name)))

    return ret


def read_news_article_file(fp) -> List[NewsArticle]:
    articles = []
    with open(fp, "r") as f:
        js_obj = json.load(f)
        for article in js_obj:
            articles.append(NewsArticle(id=article["id"], sentences=article["sentences"]))

    return articles


def transform(articles: List[NewsArticle]) -> List[EmbeddedArticle]:
    """
    Transforms a list articles sentences to a list of articles sentences embeddings
    input shape -> number of news articles * number of sentences in articles
    output shape -> number of news articles * sumber of sentences in articles * embeding size

    :param sentences:
    :return:
    """

    embeddedArticles = []

    bert = BertModel.from_pretrained("bert-base-uncased").cuda()
    tokenizer = BertTokenizerFast.from_pretrained("bert-base-uncased")

    # max_sentence_size = max([max([len(x) for x in a.sentences]) for a in articles if len(a.sentences) > 0])
    max_sentence_size = 512

    for news_article in tqdm(articles):
        try:
            sentences = news_article.sentences
            if len(sentences) < 2:
                embeddedArticles.append(EmbeddedArticle(news_article, []))
                continue

            tokenized = tokenizer(sentences,
                                  padding='max_length', max_length=max_sentence_size, truncation=True,
                                  return_tensors="pt")

            input_ids = tokenized["input_ids"].cuda()
            attention_mask = tokenized["attention_mask"].cuda()
            with torch.no_grad():
                v, out = bert(input_ids=input_ids, attention_mask=attention_mask, return_dict=False)
                asList = out.cpu().tolist()
                embeddedArticles.append(EmbeddedArticle(news_article, asList))
        except Exception as e:
            print(input_ids)
            print(attention_mask)
            print(news_article.id)
            print(e)
            raise e

    return embeddedArticles


def whiten_embeddings(embeddings: List[EmbeddedArticle]) -> List[EmbeddedArticle]:
    d = 768
    mu = 1
    x = 1
    np.cova
    mean_vector = np.array(embeddings[0].embedding) * 1
    for i in range(1, d):
        mean_vector = (i / (i + 1)) * mean_vector + (i / (i + 1)) * np.array(embeddings[i].embedding)

    embeddings = np.array([x for x in [y.embedding for y in embeddings]])

    covariance_matrix = np.cov(embeddings)
    for i in range(1, d):
        covariance_matrix = (i / (i + 1)) * covariance_matrix + (i / (i + 1)) * (embeddings[i] - mean_vector).T @ (embeddings[i] - mean_vector)
    U, L, U_T = np.linalg.svd(covariance_matrix)
    
    

    mu = [x for x in embeddings]

    pass


def main():
    to_transform = scan_for_untransformed_sentence_files()

    for ssplit_fp, out_fp in to_transform:
        articles = read_news_article_file(ssplit_fp)
        embeddings = transform(articles)
        embeddings = list(map(lambda x: x.as_json_dict(), embeddings))

        with open(out_fp, "w") as f:
            json.dump(embeddings, f)


main()
