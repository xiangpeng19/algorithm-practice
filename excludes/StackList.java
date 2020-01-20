package excludes;

import java.util.NoSuchElementException;

public class StackList {


    private final LinkedList list = new LinkedList();


    public static void main(String[] args) {

        StackList instance = new StackList();
        instance.push(1);
        instance.push(2);
        System.out.println(instance.peek());
        System.out.println(instance.pop());
        System.out.println(instance.pop());
    }

    public void push(int val) {
        list.insertFirst(val);
    }

    public int pop() {
        return list.popFirst();
    }

    public int peek() {
        return list.peekFirst();
    }


    class LinkedList {

        Node first;


        public void insertFirst(int val) {
            Node newFirst = new Node(val);
            if (first == null) {
                first = newFirst;
            } else {
                newFirst.next = first;
                first = newFirst;
            }
        }

        public int peekFirst() {
            return first.val;
        }

        public int popFirst() {
            if (first == null) {
                throw new NoSuchElementException();
            } else {
                int val = first.val;
                first = first.next;
                return val;
            }
        }

        private class Node {

            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }


    }
}