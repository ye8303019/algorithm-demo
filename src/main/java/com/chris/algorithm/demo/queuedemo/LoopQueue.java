package com.chris.algorithm.demo.queuedemo;


/**
 * Created by ye830 on 10/22/2020.
 *
 * @author Chris Ye
 */
public class LoopQueue<E> implements Queue<E> {
    private int front, tail;

    private E[] array;

    private int size;

    private int capacity;

    public LoopQueue(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
        this.capacity = array.length - 1;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public E enqueue(E value) {
        if ((tail + 1) % array.length == front) {
            resize(capacity * 2);
        }

        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return value;
    }

    @Override
    public E dequeue() {
        E result = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if (size < (capacity / 4) && capacity / 2 != 0) {
            resize(array.length / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        return array[front];
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity + 1];
        for (int i = front; i != tail; i = (i + 1) % array.length) {
            if (i >= front) {
                newArray[(i - front) % array.length] = array[i];
            } else {
                newArray[(i + array.length - front) % array.length] = array[i];
            }
        }
        array = newArray;
        front = 0;
        tail = size;
        capacity = array.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front [");

        for (int i = 0; i < size; i++) {
            sb.append(array[(i + front) % array.length]);

            if (((i + front + 1) % array.length) != tail) {
                sb.append(",");
            }
        }

        sb.append("] tail, size: " + size + ", front: " + front + ", tail " + tail + ", capacity:" + capacity);
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        for (int i = 0; i < 10; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
    }
}
