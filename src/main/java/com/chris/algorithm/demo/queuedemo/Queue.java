package com.chris.algorithm.demo.queuedemo;

/**
 * Created by ye830 on 10/17/2020.
 *
 * @author Chris Ye
 *
 */
public interface Queue<E> {
    E enqueue(E value);
    E dequeue();
    E getFront();
    int getCapacity();

}
