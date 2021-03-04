package com.chris.algorithm.demo.helper;

import com.chris.algorithm.demo.Sort.HeapSort;
import com.chris.algorithm.demo.Sort.MergeSortTest;
import com.chris.algorithm.demo.Sort.QuickSortTest;
import com.chris.algorithm.demo.Sort.ShellSort;

/**
 * Created by ye830 on 11/16/2020.
 */
public class SortTimeHelper<E extends Comparable<E>> {
    public static <E extends Comparable<E>> void sortTimeCost(E[] array, String type, int left, int right) {
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
        if ("QuickSort".equalsIgnoreCase(type)) {
            QuickSortTest.quickSort(array, left, right);
        }
        if ("RandomQuickSort".equalsIgnoreCase(type)) {
            QuickSortTest.randomQuickSort(array, left, right);
        }
        if ("MiddleQuickSort".equalsIgnoreCase(type)) {
            QuickSortTest.middleQuickSort(array, left, right);
        }
        if ("QuickSort2Ways".equalsIgnoreCase(type)) {
            QuickSortTest.quickSort2Ways(array, left, right);
        }
        if ("QuickSort3Ways".equalsIgnoreCase(type)) {
            QuickSortTest.quickSort3Ways(array, left, right);
        }
        if ("HeapSort".equalsIgnoreCase(type)) {
            HeapSort.sort(array);
        }
        if ("ShellSort".equalsIgnoreCase(type)) {
            ShellSort.sort(array);
        }
        if ("ShellSort2".equalsIgnoreCase(type)) {
            ShellSort.sort2(array);
        }
        Long endTime = System.nanoTime();
        System.out.println(array.length + " Size Array " + type + " Time Cost:" + (endTime - startTime) / 1000000000.0);
    }
}
