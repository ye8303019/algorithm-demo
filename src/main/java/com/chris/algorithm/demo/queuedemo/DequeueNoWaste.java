package com.chris.algorithm.demo.queuedemo;

/**
 * Created by ye830 on 10/24/2020.
 */
public class DequeueNoWaste<E> {

    private E[] array;

    private int capacity, size, front, tail;


    public DequeueNoWaste(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.capacity = array.length;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public DequeueNoWaste() {
        this(10);
    }

    public E addFront(E value) {
        if (size == array.length) {
            resize(capacity * 2);
        }
        if (size > 0) {
            front = front == 0 ? array.length - 1 : front - 1;
        }
        array[front] = value;
        size++;
        return value;
    }

    public E removeFront() {
        if (size == 0) {
            throw new IllegalArgumentException("No element in the queue");
        }
        E result = array[front];
        array[front] = null;
        size--;
        if (size > 1) {
            front = front == array.length - 1 ? front = 0 : front + 1;
        }
        if (size < capacity / 4 && capacity / 2 != 0) {
            resize(capacity / 2);
        }
        return result;
    }

    public E addLast(E value) {
        if (size == array.length) {
            resize(capacity * 2);
        }
        if (size != 0) {
            tail = (tail + 1) % array.length;
        }
        array[tail] = value;
        size++;
        return value;
    }

    public E removeLast() {
        E result = array[tail];
        array[tail] = null;
        size--;
        if (size > 0) {
            tail = tail == 0 ? array.length - 1 : tail - 1;
        }
        return result;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size - 1;
        capacity = array.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front [");

        for (int i = 0; i < size; i++) {
            sb.append(array[(i + front) % array.length]);

            if ((i + front) % array.length != tail) {
                sb.append(",");
            }
        }

        sb.append("] tail, size: " + size + ", front: " + front + ", tail " + tail + ", capacity:" + capacity);
        return sb.toString();
    }

    public static void main(String[] args) {
        DequeueNoWaste<Integer> dequeue = new DequeueNoWaste<>();
        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                dequeue.addLast(i);
                System.out.println(dequeue);
            }
            if (i % 2 == 1) {
                dequeue.addFront(i);
                System.out.println(dequeue);
            }
        }
        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                dequeue.removeLast();
                System.out.println(dequeue);
            }
            if (i % 2 == 1) {
                dequeue.removeLast();
                System.out.println(dequeue);
            }
        }
    }
}
