package com.chris.algorithm.demo.linkedlistdemo;

import com.chris.algorithm.demo.stackdemo.Stack;

/**
 * Created by ye830 on 10/29/2020.
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack(LinkedList<E> linkedList){
        this.linkedList = linkedList;
    }

    public LinkedListStack(){
        this.linkedList = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Top ");
        sb.append(linkedList);
        return sb.toString();
    }

    @Override
    public E push(E value){
        return linkedList.addFirst(value);
    }

    @Override
    public E pop(){
        return linkedList.removeFirst();
    }

    @Override
    public E peek(){
        return linkedList.get(0);
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for(int i =0; i < 20; i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);

            if(i % 3 == 2){
                linkedListStack.pop();
                System.out.println(linkedListStack);
            }
        }
    }
}
