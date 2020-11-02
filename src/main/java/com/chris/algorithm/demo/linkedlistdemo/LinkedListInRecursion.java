package com.chris.algorithm.demo.linkedlistdemo;

/**
 * Created by ye830 on 10/26/2020.
 */
public class LinkedListInRecursion<E> {
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

    private Node head;
    private int size;

    public LinkedListInRecursion() {
        this.head = null;
        this.size = 0;
    }

    public E add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        head = add(head, value, index);
        size++;
        return value;
    }

    public Node add(Node node, E value, int index) {
        if (index == 0) {
            return new Node(value, node);
        } else {
            node.next = add(node.next, value, index - 1);
            return node;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        head = remove(head, index);
        size--;
    }

    public Node remove(Node node, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        if (index == 0) {
            return node.next;
        } else {
            node.next = remove(node.next, index - 1);
            return node;
        }
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }


    public E addFirst(E value) {
        return add(0, value);
    }

    public E addLast(E value) {
        return add(size, value);
    }

    public void set(int index, E value) {
        set(head, index, value);
    }

    public void set(Node node, int index, E value) {
        if (index == 0) {
            node.value = value;
        } else {
            set(node.next, index - 1, value);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        return get(head, index);
    }

    public E get(Node node, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should great equal 0 and less than list size");
        }
        if (index == 0) {
            return (E) node.value;
        } else {
            return get(node.next, index - 1);
        }
    }

    public boolean contain(E value) {
        return contain(head, value);
    }

    public boolean contain(Node node, E value) {
        if (node.next == null) {
            return false;
        } else if (node.value != null && node.value == value) {
            return true;
        } else {
            return contain(node.next, value);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.value.toString() + "->");
        }
        sb.append("NULL, Size:");
        sb.append(getSize());
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListInRecursion<Integer> linkedList = new LinkedListInRecursion<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println("==== Test Set ====");

        for (int i = 0; i < 10; i++) {
            if (i % 3 == 2) {
                linkedList.set(i, i * 10);
                System.out.println(linkedList);
            }
        }

        System.out.println("==== Test Contain ====");

        for (int i = 0; i < 10; i++) {
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
    }
}
