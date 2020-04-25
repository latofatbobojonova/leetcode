//https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.getOrDefault(key, null);

        if (node != null) {
            moveToHead(key);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).val = value;
            moveToHead(key);
            return;
        }

        Node newNode = new Node(key, value);
        nodeMap.put(key, newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        if (size < capacity) {
            size++;
        } else {
            tail.prev.next = null;
            nodeMap.remove(tail.key);
            tail = tail.prev;
        }
    }

    private void moveToHead(int key) {
        Node node = nodeMap.get(key);

        // Most recently used
        if (node == head) return;

        // Least recently used or In the middle
        if (node == tail) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
