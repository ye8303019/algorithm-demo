package com.chris.algorithm.demo.queuedemo;


/**
 * Created by ye830 on 10/22/2020.
 *
 * @author Chris Ye
 */
public class LoopQueueNoWaste<E> implements Queue<E> {
    private int front, tail;

    private E[] array;

    private int size;

    private int capacity;

    public LoopQueueNoWaste(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.capacity = array.length;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueueNoWaste() {
        this(10);
    }

    @Override
    public E enqueue(E value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        if (front == tail && size == 0) {
            array[tail] = value;
        } else {
            tail = (tail + 1) % array.length;
            array[tail] = value;
        }
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
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size == 0 ? 0 : size - 1;
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
        LoopQueueNoWaste<Integer> loopQueue = new LoopQueueNoWaste<>();
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }

//        for (int i = 0; i < 20; i++) {
//            loopQueue.dequeue();
//            System.out.println(loopQueue);
//        }

//        int batchSize = 1000000;
//
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        System.out.println("ArrayQueue time cost:" + benchmarkTest(arrayQueue, batchSize));
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        System.out.println("LoopQueue time cost:" + benchmarkTest(loopQueue, batchSize));
//
//        LoopQueueNoWaste<Integer> loopQueueNoWaste = new LoopQueueNoWaste<>();
//        System.out.println("LoopQueueNoWaste time cost:" + benchmarkTest(loopQueueNoWaste, batchSize));
    }

    private static double benchmarkTest(Queue<Integer> queue, int batchSize) {
        long start = System.nanoTime();
        for (int i = 0; i < batchSize; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < batchSize; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}
