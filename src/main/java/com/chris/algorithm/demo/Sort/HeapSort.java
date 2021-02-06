package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.arraydemo.Array;
import com.chris.algorithm.demo.heap.MaxHeap;
import com.chris.algorithm.demo.helper.SortTimeHelper;

import java.util.Random;

/**
 * Created by ye830 on 2/7/2021.
 */
public class HeapSort {
    private HeapSort() {

    }

    public static <E extends Comparable> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap(data.length);
        for (E e : data) {
            maxHeap.add(e);
        }

        // asc
        for (int i = 0; i < data.length; i++) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = new Integer[n];
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = ran.nextInt(Integer.MAX_VALUE);
        }
        Integer[] array2 = array.clone();
        Integer[] array3 = array.clone();

        SortTimeHelper.sortTimeCost(array, "HeapSort", 0, n - 1);
        SortTimeHelper.sortTimeCost(array2, "QuickSort2Ways", 0, n - 1);
        SortTimeHelper.sortTimeCost(array3, "QuickSort3Ways", 0, n - 1);

    }
}
