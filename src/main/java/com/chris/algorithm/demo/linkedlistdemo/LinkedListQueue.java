package com.chris.algorithm.demo.linkedlistdemo;

import com.chris.algorithm.demo.queuedemo.Queue;

/**
 * Created by ye830 on 10/29/2020.
 *
 * @author Chris Ye
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E enqueue(E value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
        return value;

    }

    @Override
    public E dequeue() {
        size--;
        if (head == null) {
            return null;
        } else {
            Node resultNode = head;
            E result = (E) resultNode.value;
            head = head.next;
            resultNode.next = null;
            return result;
        }
    }

    @Override
    public E getFront() {
        if (tail != null) {
            return (E) tail.value;
        }
        return null;
    }


    @Override
    public int getCapacity() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Front [");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        sb.append("] Tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 20; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if(i % 3 == 2){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
