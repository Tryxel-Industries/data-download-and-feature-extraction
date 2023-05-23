from typing import List

from datasets.dataset_base import DatasetBase
from entitys import NewsArticle


class FNNDataset(DatasetBase):

    def __init__(self):
        super().__init__(dataset_name="FNN")
