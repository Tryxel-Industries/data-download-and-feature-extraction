#!/bin/bash
protoc  -I=./ --java_out=./java_feature_gen/src/main/java/ ./proto/news_dataset_sentences.proto
protoc  -I=./ --java_out=./java_feature_gen/src/main/java/ ./proto/news_dataset_semantic_features.proto
