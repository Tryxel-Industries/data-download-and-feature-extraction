from typing import List

from proto.news_dataset_embeddings_pb2 import Embedding, DatasetEmbeddings, NewsEntryEmbeddings


class NewsArticle:
    def __init__(self, id: int, label: str, publish_date: int, sentences: List[str]):
        self.publish_date = publish_date
        self.label = label
        self.sentences = sentences
        self.id = id


class EmbeddedArticle:
    def __init__(self, newsArticle: NewsArticle, embeddings: List[List[float]]):
        self.publish_date = newsArticle.publish_date
        self.label = newsArticle.label
        self.embeddings = embeddings
        self.sentences = newsArticle.sentences
        self.id = newsArticle.id

    def as_proto_obj(self):
        proto_obj = NewsEntryEmbeddings()
        proto_obj.id = self.id
        proto_obj.publish_date = self.publish_date
        proto_obj.label = self.label

        sentence_embeddings = []
        for n, embedding in enumerate(self.embeddings):
            embedding_obj = Embedding()
            embedding_obj.sentence_id = n + 1
            embedding_obj.embedding_value.extend(embedding)
            sentence_embeddings.append(embedding_obj)

        proto_obj.embeddings.extend(sentence_embeddings)
        return proto_obj
