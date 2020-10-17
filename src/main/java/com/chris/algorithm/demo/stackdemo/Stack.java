package com.chris.algorithm.demo.stackdemo;

/**
 * Created by ye830 on 10/17/2020.
 *
 * @author Chris Ye
 */
public interface Stack<E> {

    /**
     * Push the value into stack
     *
     * @param value pushed value
     * @return pushed value
     */
    E push(E value);

    /**
     * Pop out the last element of the stack
     *
     * @return the value of the last element
     */
    E pop();

    /**
     * Have a peek of the the last element of the array
     *
     * @return the value of the last element
     */
    E peek();
}
