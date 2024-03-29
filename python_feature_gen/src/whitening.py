import copy
from typing import List

import numpy as np

from entitys import EmbeddedArticle, NewsArticle


class Whitener:
    def __init__(self, num_dims):
        self.covariance_matrix = np.zeros((num_dims, num_dims))
        self.mu_vec = np.zeros(num_dims)
        self.n = 0

    def update(self, embedded_articles: List[EmbeddedArticle]):
        embeddings = np.array([x for x in [j for y in embedded_articles for j in y.embeddings]])
        new_n = len(embeddings)
        new_mu = np.mean(embeddings, axis=0, keepdims=True)
        new_cov = np.cov(embeddings.T)

        self.mu_vec = self.mu_vec = (self.n / (self.n + new_n)) * self.mu_vec + (new_n / (self.n + new_n)) * new_mu
        self.covariance_matrix = (self.n / (self.n + new_n)) * self.covariance_matrix + (
                new_n / (self.n + new_n)) * new_cov
        self.n += new_n

    # NB: antar at alle embedded articles allerede har blitt kjørt gjennom update!
    def whiten_embeddings(self, embedded_articles_in: List[EmbeddedArticle], desired_dims: int = None) -> List[
        EmbeddedArticle]:
        embedded_articles = copy.deepcopy(embedded_articles_in)
        embeddings = np.array([x for x in [j for y in embedded_articles for j in y.embeddings]])
        desired_dims = embeddings.shape[1] if (
                desired_dims is None or desired_dims < 0 or desired_dims > embeddings.shape[1]) else desired_dims
        # mu = np.mean(embeddings, axis=0, keepdims=True)
        # cov = np.cov(embeddings.T)
        u, s, vh = np.linalg.svd(self.covariance_matrix)
        w = np.dot(u, np.diag(1 / np.sqrt(s)))
        # op = w.T @ self.covariance_matrix @ w
        # print(len(op[op > 0.9]))
        for article in embedded_articles:
            try:
                article.embeddings = (article.embeddings - self.mu_vec) @ w[:, :desired_dims]
            except Exception as e:
                print("embed: ", article.embeddings)
                print("sentences: ", article.sentences)
                print(article)
                print("article id: ", article.id)
                print(e)
        return embedded_articles
