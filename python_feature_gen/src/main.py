import json
import os
from typing import List

import torch
from tqdm import tqdm
from transformers import BertConfig, BertModel, BertTokenizerFast

from datasets.buzfeed_dataset import BuzfeedDataset
from datasets.gosipcop_dataset import GosipcopDataset
from datasets.politifact import PolitifactDataset
from datasets.kaggle_dataset import KaggleDataset
from entitys import NewsArticle, EmbeddedArticle
from make_embedding import transform
from proto.proto_io import read_sentences, write_sentences


def scan_for_untransformed_sentence_files(out_dir_base_path: str, embedding_fn_pattern: str):
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


def main():
    # datasett = BuzfeedDataset()
    # datasett.build_and_save_embeddings(num_to_save=5000, whitening_num_dims=[256, 90])

    datasett = GosipcopDataset()
    datasett.build_and_save_embeddings(num_to_save=5000, whitening_num_dims=[256, 90])

    datasett = PolitifactDataset()
    datasett.build_and_save_embeddings(num_to_save=5000, whitening_num_dims=[256, 90])

    datasett = KaggleDataset()
    datasett.build_and_save_embeddings(num_to_save=5000, whitening_num_dims=[256, 90])

    # datasett = FNNDataset()
    # datasett.build_and_save_embeddings(num_to_save=None, whitening_num_dims=256)
    # to_transform = scan_for_untransformed_sentence_files(out_dir_base_path)

    # for ssplit_fp, out_fp in to_transform:
    #     articles = read_news_article_file(ssplit_fp)
    #     embeddings = transform(articles)
    #     embeddings = list(map(lambda x: x.as_json_dict(), embeddings))
    #
    #     with open(out_fp, "w") as f:
    #         json.dump(embeddings, f)


def main2_bogaloo():
    pass
    # read_sentences(out_dir_base_path + "kaggle/sentences_proto.bin")

    # na = NewsArticle(1, "t", 1, ["aaaaa", "bbbb"])
    # eba = EmbeddedArticle(na, [[1, 2, 3], [4, 5, 6]])
    # proto = eba.as_proto_obj()
    # write_sentences(out_dir_base_path + "kaggle/embeddings_proto.bin", proto)
    #


if __name__ == '__main__':
    # main()
    main()
