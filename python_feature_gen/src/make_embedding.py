import json
import math
import os
from typing import List

import torch
from tqdm import tqdm
from transformers import BertConfig, BertModel, BertTokenizerFast

from entitys import NewsArticle, EmbeddedArticle


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
    max_s_num = 100

    for news_article in tqdm(articles):
        article_embeddings = []
        try:
            sentences = news_article.sentences
            n_iters = math.ceil(len(sentences) / max_s_num)

            for n in range(n_iters):

                if n == n_iters - 1:
                    to_transform = sentences[n * max_s_num:]
                else:
                    to_transform = sentences[n * max_s_num:(n + 1) * max_s_num]

                # if len(sentences) < 2:
                #     embeddedArticles.append(EmbeddedArticle(news_article, []))
                #     continue

                tokenized = tokenizer(to_transform,
                                      padding='max_length', max_length=max_sentence_size, truncation=True,
                                      return_tensors="pt")

                input_ids = tokenized["input_ids"].cuda()
                attention_mask = tokenized["attention_mask"].cuda()
                with torch.no_grad():
                    v, out = bert(input_ids=input_ids, attention_mask=attention_mask, return_dict=False)
                    asList = out.cpu().tolist()
                    article_embeddings = [*article_embeddings, *asList]
            embeddedArticles.append(EmbeddedArticle(news_article, article_embeddings))
        except Exception as e:
            print(input_ids)
            print(attention_mask)
            print(news_article.id)
            print(e)
            raise e

    return embeddedArticles
