package com.chris.algorithm.demo.heap;

import com.chris.algorithm.demo.arraydemo.Array;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * 最大堆的定义:
 * 一颗完全二叉树
 * 顺序的从左至右排列
 * 不满的那部分一定是在右下方
 * 所有节点比其子节点都要大
 */
public class MaxHeap<E extends Comparable> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("no more parent for index - 0");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() <= 0) {
            throw new IllegalArgumentException("No item in the tree");
        }
        return data.get(0);
    }

    public E extractMax() {
        E temp = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return temp;
    }

    /**
     * 元素下沉的思路是：
     * 1 - 通过和左右节点比较，获取最大的元素，如果最大元素不是当前节点，则下沉
     * 1.1 - 因为当需要下沉的时候，一定会有左节点。所以先获取左节点
     * 1.2 - 再判断是否有有右节点，判断的依据是右节点不超出数组大小，同时判断右节点是不是比左节点大
     * 2 - 循环直至当前节点的左侧子节点超出数据最大边界（因为左侧超出，右侧肯定超出）
     *
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (rightChild(k) < data.getSize() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) < 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1]) {
                throw new RuntimeException("Something wrong");
            }
        }
        System.out.println("MaxHeap running good.");
    }
}
