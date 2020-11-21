package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;
import com.chris.algorithm.demo.helper.ArrayHelper;
import com.chris.algorithm.demo.helper.SortTimeHelper;
import com.chris.algorithm.demo.helper.SwapHelper;

/**
 * Created by ye830 on 11/21/2020.
 */
public class QuickSortTest<E extends Comparable<E>> {
    public static <E extends Comparable<E>> void quickSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int position = partition(array, left, right);
        quickSort(array, left, position - 1);
        quickSort(array, position + 1, right);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int left, int right) {
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i].compareTo(array[left]) < 0) {
                j++;
                if(i != j){
                    SwapHelper.swap(array, j, i);
                }
            }
        }
        if(j != left){
            SwapHelper.swap(array, j, left);
        }
        return j;
    }

    public static void main(String[] args) {
        //Integer[] array = {3, 2, 1, 5, 4};
        int size = 5000000;
        Integer[] array = ArrayGenerator.generateRandomArray(size, size);
        Integer[] array2 = array.clone();
        //System.out.println(ArrayHelper.arrayToStr(array));
        SortTimeHelper.sortTimeCost(array, "QuickSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSortWithCopiedArray", 0, array2.length - 1);
        //System.out.println(ArrayHelper.arrayToStr(array));
    }
}
