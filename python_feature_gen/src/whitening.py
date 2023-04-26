from typing import List

import numpy as np

from entitys import EmbeddedArticle


class whitener:
    def __init__(self, num_dims):
        self.covariance_matrix = np.identity(num_dims)
        self.mu_vec = np.zeros(num_dims)
        self.n = 0

    def update(self, embedded_articles: List[EmbeddedArticle]):
        embeddings = np.array([x for x in [y.embeddings for y in embedded_articles for j in j]])
        new_n = len(embeddings)
        new_mu = np.mean(embeddings, axis=0, keepdims=True)
        new_cov = np.cov(embeddings.T)
        
        self.mu_vec = self.mu_vec = (self.n/(self.n + new_n)) * self.mu_vec + (new_n/(self.n + new_n)) * new_mu
        self.covariance_matrix = (self.n/(self.n + new_n)) * self.covariance_matrix + (new_n/(self.n + new_n)) * new_cov
        self.n += new_n

    #NB: antar at alle embedded articles allerede har blitt kjørt gjennom update!
    def whiten_embeddings(self, embedded_articles: List[EmbeddedArticle], desired_dims: int = None) -> np.array:
        embeddings = np.array([x for x in [y.embeddings for y in embedded_articles for j in j]])
        desired_dims = embeddings.shape[1] if (
                desired_dims is None or desired_dims < 0 or desired_dims > embeddings.shape[1]) else desired_dims
        print(desired_dims)
        # mu = np.mean(embeddings, axis=0, keepdims=True)
        # cov = np.cov(embeddings.T)
        u, s, vh = np.linalg.svd(self.covariance_matrix)
        w = np.dot(u, np.diag(1 / np.sqrt(s)))
        op = w.T @ self.covariance_matrix @ w
        print(len(op[op > 0.9]))
        return (embeddings - self.mu_vec) @ w[:, :desired_dims]
