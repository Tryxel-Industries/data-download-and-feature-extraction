import os.path
from abc import abstractmethod
from typing import List, Optional

from entitys import NewsArticle
from make_embedding import transform
from proto.news_dataset_embeddings_pb2 import DatasetEmbeddings
from proto.proto_io import read_sentences, write_sentences
from whitening import Whitener

out_dir_base_path = "./../data_out/"
sentences_fn = "sentences_proto.bin"
embedding_fn = "embeddings_proto.bin"


class DatasetBase:

    def __init__(self, dataset_name: str):
        self.dataset_name = dataset_name
        self.embedding_fp = self._get_write_dir() + embedding_fn
        self.sentence_fp = self._get_write_dir() + sentences_fn

        self.news_articles = self._parse_dataset_files()

    def _get_write_dir(self):
        return out_dir_base_path + self.dataset_name.lower() + "/"

    def is_embedding_made(self):
        return os.path.isfile(self.embedding_fp)

    def is_sentences_present(self):
        return os.path.isfile(self.sentence_fp)

    def build_and_save_embeddings(self, num_to_save: Optional[int], whitening_num_dims: [int]):
        if num_to_save is None:
            embedded_articles = transform(self.news_articles)
        else:
            embedded_articles = transform(self.news_articles[:num_to_save])

        embedded_transformed = [e.as_proto_obj() for e in embedded_articles]

        datasett = DatasetEmbeddings()
        datasett.dataset_name = self.dataset_name
        datasett.news_entries.extend(embedded_transformed)

        write_sentences(self.embedding_fp, datasett)

        wth = Whitener(len(embedded_articles[0].embeddings[0]))
        wth.update(embedded_articles)

        for n in whitening_num_dims:
            whitened = wth.whiten_embeddings(embedded_articles, desired_dims=n)

            datasett = DatasetEmbeddings()
            datasett.dataset_name = self.dataset_name

            whitened_transformed = [e.as_proto_obj() for e in whitened]
            datasett.news_entries.extend(whitened_transformed)

            write_sentences(self.embedding_fp + f".whitened_{n}", datasett)

    # @abstractmethod
    def _parse_dataset_files(self) -> List[NewsArticle]:
        print(self.sentence_fp)
        return read_sentences(self.sentence_fp)
        pass
