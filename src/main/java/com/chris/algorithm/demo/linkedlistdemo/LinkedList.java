package com.chris.algorithm.demo.linkedlistdemo;

/**
 * Created by ye830 on 10/26/2020.
 */
public class LinkedList<E> {
    private class Node<E> {
        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(value, prev.next);
        size++;
    }

    public void addFirst(E value) {
        add(0, value);
    }

    public void addLast(E value) {
//        Node prev = dummyHead;
//        for (Node cur = prev.next; cur != null; cur = cur.next) {
//            prev = cur;
//        }
//        prev.next = new Node(value, prev.next);
//        size++;

        add(size-1, value);
    }

    public void set(int index, E value) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.value = value;
    }

    public boolean contain(E value) {
        Node prev = dummyHead;
        for (Node cur = prev.next; cur != null; cur = cur.next) {
            if (cur.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.value.toString() + "->");
        }
        sb.append("NULL, Size:");
        sb.append(getSize());
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i<10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println("==== Test Set ====");

        for (int i = 0; i<10; i++) {
            if(i % 3 == 2){
                linkedList.set(i, i*10);
                System.out.println(linkedList);
            }
        }

        System.out.println("==== Test Contain ====");

        for (int i = 0; i<10; i++) {
            if(i % 4 == 3){
                System.out.println(linkedList.contain(i));
            }
        }

        System.out.println("==== Test addLast ====");

        linkedList.addLast(100);
        System.out.println(linkedList);
    }
}
