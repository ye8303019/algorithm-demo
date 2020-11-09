package com.chris.algorithm.demo.linkedlistdemo;

import com.chris.algorithm.demo.arraydemo.Array;

/**
 * Created by ye830 on 10/26/2020.
 */
public class LinkedList<E extends Comparable<E>> {
    private static class Node<E> {
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

    public LinkedList(E[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Illegal array");
        }
        this.dummyHead = new Node(null, null);
        this.size = 0;
        Node cur = dummyHead;
        for (E value : array) {
            cur.next = new Node(value);
            cur = cur.next;
            size++;
        }
        cur.next = null;
    }

    public E add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(value, prev.next);
        size++;
        return value;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        E result = (E) cur.value;
        cur.next = null;
        size--;
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    public E addFirst(E value) {
        return add(0, value);
    }

    public E addLast(E value) {
//        Node prev = dummyHead;
//        for (Node cur = prev.next; cur != null; cur = cur.next) {
//            prev = cur;
//        }
//        prev.next = new Node(value, prev.next);
//        size++;

        return add(size - 1, value);
    }

    public void set(int index, E value) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.value = value;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return (E) prev.next.value;
    }

    public void sort(String sortType) {
        for (int i = 1; i <= size - 1; i++) {
            Node cur = dummyHead.next;
            for (int j = 0; j < size - i; j++) {
                if (sortType.equalsIgnoreCase("asc")) {
                    if (((E) cur.value).compareTo(((E) cur.next.value)) > 0) {
                        E value = (E) cur.next.value;
                        cur.next.value = cur.value;
                        cur.value = value;
                    }
                }
                if (sortType.equalsIgnoreCase("desc")) {
                    if (((E) cur.value).compareTo(((E) cur.next.value)) < 0) {
                        E value = (E) cur.next.value;
                        cur.next.value = cur.value;
                        cur.value = value;
                    }
                }
                cur = cur.next;
            }
        }
    }

    public static <E extends Comparable<E>> E compare(E[] array) {
        E m = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(m) < 0) {
                m = array[i];
            }
        }
        System.out.println(m);
        return m;
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
        System.out.println("==== Test construct from array ====");
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 7, 8};
        LinkedList<Integer> linkedList = new LinkedList<>(array);
        System.out.println(linkedList);

        System.out.println("==== Test addFirst ====");

        for (int i = 10; i < 20; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println("==== Test Set ====");

        for (int i = 10; i < 20; i++) {
            if (i % 3 == 2) {
                linkedList.set(i, i * 10);
                System.out.println(linkedList);
            }
        }

        System.out.println("==== Test Contain ====");

        for (int i = 10; i < 20; i++) {
            if (i % 4 == 3) {
                System.out.println(linkedList.contain(i));
            }
        }

        System.out.println("==== Test addLast ====");

        linkedList.addLast(100);
        System.out.println(linkedList);

        System.out.println("==== Test Remove ====");

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        System.out.println("==== Test Get ====");

        System.out.println(linkedList.get(0));

        System.out.println("==== Test Add ====");

        linkedList.add(8, 200);
        System.out.println(linkedList);

        System.out.println("==== Test Sort ====");

        linkedList.sort("asc");
        System.out.println(linkedList);
    }
}
