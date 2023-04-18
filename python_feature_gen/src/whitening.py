from typing import List

import numpy as np

from entitys import EmbeddedArticle


def whiten_embeddings(embeddings: List[EmbeddedArticle], desired_dims: int = None) -> np.array:
    embeddings = np.array([x for x in [y.embedding for y in embeddings]])
    desired_dims = embeddings.shape[1] if (
            desired_dims is None or desired_dims < 0 or desired_dims > embeddings.shape[1]) else desired_dims
    print(desired_dims)
    mu = np.mean(embeddings, axis=0, keepdims=True)
    cov = np.cov(embeddings.T)
    u, s, vh = np.linalg.svd(cov)
    w = np.dot(u, np.diag(1 / np.sqrt(s)))
    op = w.T @ cov @ w
    print(len(op[op > 0.9]))
    return (embeddings - mu) @ w[:, :desired_dims]
