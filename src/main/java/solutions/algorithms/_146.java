package solutions.algorithms;

import java.util.HashMap;
import java.util.Map;

public class _146 {

    /**
     * Create a hash map, key is the input key, value is the new structure we defined as Node. Node
     * will be double linked list.
     * <p>
     * For get: we will return the value from map by using the key, and then move the node to front
     * of the linked list.
     * <p>
     * For put, we will insert an new entry into map and insert the node to the front of the linked
     * list. If the capacity is greater than the designed capacity, we also remove the end of the
     * linked list.
     * <p>
     * For easier access, we will create two pointer (start, end) to always point to two ends of the
     * linked list.
     */
    static class LRUCache {

        private Map<Integer, Node> recordMap;
        private int capacity;
        private Node start;
        private Node end;

        public LRUCache(int capacity) {
            this.recordMap = new HashMap<>();
            this.capacity = capacity;
            this.start = null;
            this.end = null;
        }

        public int get(int key) {
            if (recordMap.containsKey(key)) {
                Node node = recordMap.get(key);
                // multiple cases:
                // 1) Node is the end
                // 2) Node is the start, no-op
                // 3) Node is the end and the start, no-op
                // 4) Node is none of above

                if (node == start && node == end) {
                    // case 3
                    return node.val;
                } else if (node == start) {
                    // case 2
                    return node.val;
                } else if (node == end) {
                    // case 1
                    end = node.next; // move end to one next
                    start.next = node; // add node to start
                    start = node; // modify start node
                } else if (node.pre != end && node.next != start) {
                    // case 4
                    node.pre = node.next; // delete the node in between
                    start.next = node; // add node to start
                    start = node;  //  modify start node
                }
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;

            // special case, this is the first record.
            if (recordMap.isEmpty()) {
                start = newNode;
                end = newNode;
            } else {
                start.next = newNode;
                start = newNode;
            }
            // store the new node into map
            recordMap.put(key, newNode);

            if (recordMap.size() > capacity) {
                // not enough capacity, need to remove the end node
                recordMap.remove(end.key);
                end = end.next;
            }
        }

        class Node {

            int key;
            int val;
            Node pre;
            Node next;
        }
    }

}
