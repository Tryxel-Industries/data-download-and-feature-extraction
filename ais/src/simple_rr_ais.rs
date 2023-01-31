use std::cmp::Ordering;
use std::collections::BinaryHeap;
use std::os::unix::raw::ino_t;
use crate::enums::TrueFalseLabel;
use crate::model::{EmbeddingElement, NewsArticle, SimpleDistance};

//
// Traits
//
pub trait Bucketable {
    fn get_dimensional_value(&self, dim: usize) -> &f64;
}


//
// structs
//

pub struct BucketValue {
    article_id: i32,
    sentence_id: i32,
    label: TrueFalseLabel,
}

pub struct BucketIndexer {
    indexer_value: i32,
}


pub struct Bucket {
    // The plebs of the bucket empire
    // inclusive
    start_value: f64,
    // exclusive
    end_value: f64,

    bucket_contents: Vec<usize>,
}

pub struct BucketKnight {
    // The executive arm of the bucket empire
    buckets: Vec<Bucket>,
    dimension: usize,
}

pub struct BucketKing {
    // he who rules the buckets
    dimensional_knights: Vec<BucketKnight>,
}

//
// impl
//

impl Bucketable for EmbeddingElement {
    fn get_dimensional_value(&self, dim: usize) -> &f64 {
        return self.embedding.get(dim)?;
    }
}

impl Bucket {
    pub fn add_items(&mut self, items: Vec<BucketValue>) {
        self.bucket_contents.extend(items);
        self.bucket_contents.sort_unstable_by_key(|k| k.article_id);
    }
}

impl BucketKnight {
    pub fn get_bucket(&self, dimensional_value: &f64) -> Option<&Bucket> {
        let value = dimensional_value;
        for bucket in self.buckets {
            if bucket.start_value < *value {
                if bucket.end_value > *value {
                    return Some(&bucket);
                }
            }
        }
        return None;
    }

    pub fn add_items(&mut self, ) {}
}


impl Eq for BucketValue {}

impl PartialEq<Self> for BucketValue {
    fn eq(&self, other: &Self) -> bool {
        self.article_id.eq(&other.article_id)
    }
}

impl PartialOrd<Self> for BucketValue {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        return self.article_id.partial_cmp(&other.article_id);
    }
}

impl Ord for BucketValue {
    fn cmp(&self, other: &Self) -> Ordering {
        return self.article_id.total_cmp(&other.article_id);
    }
}


struct SimpleRRAis {}

impl SimpleRRAis {
    pub fn train(articles: Vec<NewsArticle>) {}
}
