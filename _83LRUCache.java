//Leetcode - 146 - LRU Cache

//Solution using - HashMap & Doubly Linked List
//time comp - O(1) for get & put

import java.util.LinkedHashMap;

class LRUCache {
    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // make 2 dummy nodes, head & tail
    Node head = new Node(0, 0), tail = new Node(0, 0);
    // Hashmap - to locate where our node is
    Map<Integer, Node> map = new HashMap<>();
    int cap; // capacity

    // object function or parameterized constructor
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        // if key already exist in map
        if (map.containsKey(key))
            remove(map.get(key));
        // if hashmap size equals capacity
        if (map.size() == cap)
            remove(tail.prev);
        // insert the node right after head
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        // remove it from map
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */