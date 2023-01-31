from typing import List

import torch
from tqdm import tqdm
from transformers import BertConfig, BertModel, BertTokenizerFast


class NewsArticle:
    def __init__(self, id: int, sentences: List[str]):
        self.sentences = sentences
        self.id = id


class EmbeddedArticle:
    def __init__(self, newsArticle: NewsArticle, embedding: List[float]):
        self.embedding = embedding
        self.sentences = newsArticle.sentences
        self.id = newsArticle.id


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

    for news_article in tqdm(articles):
        sentences = news_article.sentences

        max_sentence_size = max([len(x) for x in sentences])

        tokenized = tokenizer(sentences,
                              padding='max_length', max_length=max_sentence_size, truncation=True,
                              return_tensors="pt")

        input_ids = tokenized["input_ids"].cuda()
        attention_mask = tokenized["attention_mask"].cuda()
        with torch.no_grad():
            v, out = bert(input_ids=input_ids, attention_mask=attention_mask, return_dict=False)
            embeddedArticles.append(EmbeddedArticle(news_article, out))

    return embeddedArticles


articles = []
for i in range(500):
    text = ["U.S.A yeaahhh!!!!", "i am confident that Bob rigged the ugandan election last tuesday.",
            "is this — real??????", "really 100 000 dollas tells me no way any1 cold do that 360 kick-flip?",
            "thight-lipped!", "idk means I dont know - mine my opinion you yours opinion.",
            "if this ain't “posible” \"to\" 'tokenize' (good) for organizations e.g. c.i.a. nsa, federal bureau of investigation and other.",
            "Earlier today Josh Caplan at The Gateway Pundit posted on Gloria Allred’s last ditch effort to swing the Alabama senate race to Democrat Doug Moore.",
            "WE CALLED IT!", "Gloria Allred Accuser **ADMITS** She Tampered With Roy Moore’s Yearbook ‘Signature’"]
    a1 = NewsArticle(i, text)
    articles.append(a1)

transform(articles)
