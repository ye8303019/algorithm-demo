package com.chris.algorithm.demo.leetcode.problem_622;

/**
 * Created by ye830 on 10/24/2020.
 * leetcode 622
 */
public class MyCircularQueue {
    private int front, tail;

    private Integer[] array;

    private int size;

    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.array = new Integer[k + 1];
        this.capacity = array.length - 1;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if ((tail + 1) % array.length == front) {
            return false;
        }

        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(size == 0){
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(size == 0){
            return -1;
        }
        return array[tail == 0 ? capacity : tail - 1];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6); // set the size to be 3
        circularQueue.enQueue(6);  // return true
        circularQueue.Rear();
        circularQueue.Rear();
        circularQueue.deQueue();
        circularQueue.enQueue(5);
        circularQueue.Rear();
        circularQueue.deQueue();
        circularQueue.Front();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.deQueue();
    }
}
