package com.dsa.flipkart;

public class LRUCacheNode {
    int key;
    int value;
    LRUCacheNode pre;
    LRUCacheNode next;

    public LRUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
