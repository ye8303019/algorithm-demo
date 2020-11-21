package com.chris.algorithm.demo.helper;

import com.chris.algorithm.demo.Sort.MergeSortTest;

/**
 * Created by ye830 on 11/16/2020.
 */
public class SwapHelper<E extends Comparable<E>> {
    public static <E extends Comparable<E>> void swap(E[] array, int src, int des) {
        E temp = array[src];
        array[src] = array[des];
        array[des] = temp;
    }
}
