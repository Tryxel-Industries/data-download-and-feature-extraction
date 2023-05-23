from typing import List

from datasets.dataset_base import DatasetBase
from entitys import NewsArticle


class BuzfeedDataset(DatasetBase):

    def __init__(self):
        super().__init__(dataset_name="buzfeed")
