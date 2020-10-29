package com.chris.algorithm.demo.linkedlistdemo;

import com.chris.algorithm.demo.stackdemo.ArrayStack;
import com.chris.algorithm.demo.stackdemo.Stack;

/**
 * Created by ye830 on 10/29/2020.
 */
public class StackCompare {
    private static double test(Stack<Integer> stack, int count) {
        Long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        System.out.println("ArrayStack execute for " + count + " times, cost: " + test(arrayStack, count) + " s");

        System.out.println("LinkedListStack execute for " + count + " times, cost: " + test(linkedListStack, count) +" s");
    }
}
