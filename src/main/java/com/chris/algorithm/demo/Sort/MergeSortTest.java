package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;
import com.chris.algorithm.demo.helper.ArrayHelper;


/**
 * Created by ye830 on 11/12/2020.
 */
public class MergeSortTest<E extends Comparable<E>> {

    public void mergeSort(E[] array, int left, int right) {
        if (array == null || left > right) {
            throw new IllegalArgumentException();
        }

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(array, left, middle);

        mergeSort(array, middle + 1, right);

        merge(array, left, middle, right);
    }

    private void merge(E[] array, int left, int middle, int right) {
        E[] bufferArray = array.clone();

        int i = left;
        int j = middle + 1;
        int index = left;

        while (i <= middle || j <= right) {
            if (i > middle && j <= right) {
                array[index] = bufferArray[j];
                j++;
            } else if (i <= middle && j > right) {
                array[index] = bufferArray[i];
                i++;
            } else if (bufferArray[i].compareTo(bufferArray[j]) <= 0) {
                array[index] = bufferArray[i];
                i++;
            } else if (bufferArray[j].compareTo(bufferArray[i]) < 0) {
                array[index] = bufferArray[j];
                j++;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 3, 9, 9, 4, 2, 8, 6};
        System.out.println("Before Array Been Merge Sorted:" + ArrayHelper.arrayToStr(array));
        new MergeSortTest().mergeSort(array, 0, 7);
        System.out.println("After Array Been Merge Sorted:" + ArrayHelper.arrayToStr(array));

        System.out.println("==========================================================");

        int size = 1000000;
        array = ArrayGenerator.generateOrderedArray(size);
        Long startTime = System.nanoTime();
        new MergeSortTest().mergeSort(array, 0, 7);
        Long endTime = System.nanoTime();
        System.out.println(size + " Size Random Value Array Merge Sorting Time Cost:" + (endTime - startTime) / 1000000000.0);
    }
}
