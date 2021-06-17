package com.dsa.flipkart;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static Map<Integer, LRUCacheNode> map;
    private static int capacity, count;
    private static LRUCacheNode head, tail;

    public static void main(String[] args) {
        map = new HashMap<>();
        capacity = 2;
        count = 0;
        head = new LRUCacheNode(0, 0);
        tail = new LRUCacheNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;

        set(1, 10);
        set(2, 20);
        System.out.println("get " + get(1));
        set(3, 30);
        System.out.println("get " + get(2));
        set(4, 40);
        System.out.println("get " + get(1));
        System.out.println("get " + get(3));
        System.out.println("get " + get(4));
    }

    private static int get(int key) {
        if (map.containsKey(key)) {
            LRUCacheNode node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        } else
            return -1;
    }

    private static void set(int key, int value) {
        LRUCacheNode node;
        if (!map.containsKey(key)) {
            node = new LRUCacheNode(key, value);
            map.put(key, node);
            if (count < capacity)
                count++;
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
        } else {
            node = map.get(key);
            node.value = value;
            deleteNode(node);
        }
        addToHead(node);
    }

    private static void addToHead(LRUCacheNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private static void deleteNode(LRUCacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
