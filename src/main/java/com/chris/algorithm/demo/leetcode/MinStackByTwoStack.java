package com.chris.algorithm.demo.leetcode;

/**
 * Created by ye830 on 10/23/2020.
 * leetcode 155
 *
 * @author Chris Ye
 */
public class MinStackByTwoStack {
    private java.util.Stack<Integer> dataStack;
    private java.util.Stack<Integer> minStack;

    public MinStackByTwoStack() {
        dataStack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= getMin()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = dataStack.pop();
        if (x == getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStackByTwoStack minStack = new MinStackByTwoStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
