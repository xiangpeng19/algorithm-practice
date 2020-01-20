package excludes;

public class LRUCache {

    int capacity;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    Map<Integer, DoubleLinkedList> map;
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        // update double linked list
        if (map.containsKey(key)) {
            DoubleLinkedList current = map.get(key);
            remove(current);
            setHead(current);
            return current.value;
        }

        return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here

        if (map.containsKey(key)) {
            DoubleLinkedList old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            DoubleLinkedList newNode = new DoubleLinkedList(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }

    private void remove(DoubleLinkedList node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void setHead(DoubleLinkedList node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }
}

class DoubleLinkedList {
    int key;
    int value;
    DoubleLinkedList pre;
    DoubleLinkedList next;

    public DoubleLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}