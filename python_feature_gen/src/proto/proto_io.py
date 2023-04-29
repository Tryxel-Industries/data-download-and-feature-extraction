from typing import List

from entitys import NewsArticle
from proto.news_dataset_embeddings_pb2 import DatasetEmbeddings
from proto.news_dataset_sentences_pb2 import DatasetSentences


def read_sentences(write_path: str) -> List[NewsArticle]:
    dataset = DatasetSentences()
    with open(write_path, "rb") as f:
        dataset.ParseFromString(f.read())

    news_articles = []
    zero_sentence_articles = 0
    for news_article in dataset.news_entries:
        sentences = []
        for sentence in news_article.sentences:
            sentences.append(sentence)
        if len(sentences) == 0:
            zero_sentence_articles += 1
            continue
        article = NewsArticle(id=news_article.id, label=news_article.label, publish_date=news_article.publish_date,
                              sentences=sentences)
        news_articles.append(article)

    if zero_sentence_articles > 0:
        print(f"{zero_sentence_articles} articles had no sentences")

    return news_articles


def write_sentences(write_path: str, datasett: DatasetEmbeddings):
    with open(write_path, "wb") as f:
        f.write(datasett.SerializeToString())
