package com.chris.algorithm.demo.stackdemo;

import com.chris.algorithm.demo.arraydemo.Array;

/**
 * Created by ye830 on 10/17/2020.
 *
 * @author Chris Ye
 */
public class ArrayStack<E> implements Stack<E> {

    private Array array;

    public ArrayStack(int capacity) {
        this.array = new Array<E>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<E>();
    }

    /**
     * Push the value into stack
     *
     * @param value pushed value
     * @return pushed value
     */
    @Override
    public E push(E value) {
        return (E) array.addLast(value);
    }

    /**
     * Pop out the last element of the stack
     *
     * @return the value of the last element
     */
    @Override
    public E pop() {
        return (E) array.removeLast();
    }

    /**
     * Have a peek of the the last element of the array
     *
     * @return the value of the last element
     */
    @Override
    public E peek() {
        return (E) array.getLast();
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
        sb.append("Head ");
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
        ArrayStack<Integer> myStack = new ArrayStack<>();
        for (int i = 0; i < 20; i++) {
            myStack.push(i);

            if(i % 3 == 2){
                myStack.pop();
            }
        }

        System.out.println(myStack);
    }
}
