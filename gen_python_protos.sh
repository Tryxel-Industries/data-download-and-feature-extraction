#!/bin/bash
protoc  -I=./ --python_out=./python_feature_gen/src/ ./proto/news_dataset_sentences.proto
protoc  -I=./ --python_out=./python_feature_gen/src/ ./proto/news_dataset_embeddings.proto
