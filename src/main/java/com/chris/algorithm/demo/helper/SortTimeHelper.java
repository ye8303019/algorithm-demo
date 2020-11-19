package com.chris.algorithm.demo.helper;

import com.chris.algorithm.demo.Sort.MergeSortTest;

/**
 * Created by ye830 on 11/16/2020.
 */
public class SortTimeHelper<E extends Comparable<E>> {
    public static <E extends Comparable<E>> void sortTimeCost(E[] array, String type, Integer left, Integer right) {
        Long startTime = System.nanoTime();
        if ("MergeSort".equalsIgnoreCase(type)) {
            new MergeSortTest().mergeSort(array, left, right);
        }
        if ("MergeSortOrdered".equalsIgnoreCase(type)) {
            new MergeSortTest().mergeSortOrdered(array, left, right);
        }
        if ("MergeSortWithCopiedArray".equalsIgnoreCase(type)) {
            E[] array2 = array.clone();
            new MergeSortTest().mergeSortWithCopiedArray(array, left, right, array2);
        }
        if ("mergeSortCombineInsertedSortWithCopiedArray".equalsIgnoreCase(type)) {
            E[] array2 = array.clone();
            new MergeSortTest().mergeSortCombineInsertedSortWithCopiedArray(array, left, right, array2);
        }
        if ("MergeSortBU".equalsIgnoreCase(type)) {
            E[] array2 = array.clone();
            new MergeSortTest().mergeSortBU(array, left, right, array2);
        }
        Long endTime = System.nanoTime();
        System.out.println(array.length + " Size Array " + type + " Time Cost:" + (endTime - startTime) / 1000000000.0);
    }
}
