package com.chris.algorithm.demo.queuedemo;

import com.chris.algorithm.demo.arraydemo.Array;

/**
 * Created by ye830 on 10/17/2020.
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public E enqueue(E value) {
        return (E) array.addLast(value);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * Return the capacity of the stack
     *
     * @return the capacity of the stack
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * Return the size of the stack
     *
     * @return the size of the stack
     */
    public int getSize() {
        return array.getSize();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Front ");
        sb.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(String.valueOf(array.get(i)));
            if (i != array.getSize() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        sb.append(" Tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> myQueue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            myQueue.enqueue(i);

            if (i % 3 == 2) {
                myQueue.dequeue();
            }
        }
        System.out.println(myQueue);
    }
}
