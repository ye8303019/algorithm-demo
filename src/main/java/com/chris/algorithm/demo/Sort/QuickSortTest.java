package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;
import com.chris.algorithm.demo.helper.ArrayHelper;
import com.chris.algorithm.demo.helper.SortTimeHelper;
import com.chris.algorithm.demo.helper.SwapHelper;

import java.util.Random;

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

    public static <E extends Comparable<E>> void quickSort2Ways(E[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int position = partition2ways(array, left, right);
        quickSort(array, left, position - 1);
        quickSort(array, position + 1, right);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int left, int right) {
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i].compareTo(array[left]) < 0) {
                j++;
                if (i != j) {
                    SwapHelper.swap(array, j, i);
                }
            }
        }
        if (j != left) {
            SwapHelper.swap(array, j, left);
        }
        return j;
    }

    private static <E extends Comparable<E>> int partition2ways(E[] array, int left, int right) {
        int p = left + rnd.nextInt(right - left + 1);
        SwapHelper.swap(array, left, p);

        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && array[i].compareTo(array[left]) < 0) {
                i++;
            }

            while (j >= i && array[j].compareTo(array[left]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            SwapHelper.swap(array, i, j);

            i++;
            j--;
        }
        SwapHelper.swap(array, left, j);
        return j;
    }

    private static Random rnd = new Random();

    public static <E extends Comparable<E>> void randomQuickSort(E[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = left + rnd.nextInt(right - left + 1);
        SwapHelper.swap(array, p, left);

        int position = partition(array, left, right);
        randomQuickSort(array, left, position - 1);
        randomQuickSort(array, position + 1, right);
    }

    public static <E extends Comparable<E>> void middleQuickSort(E[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = left + (right - left) / 2;
        SwapHelper.swap(array, p, left);

        int position = partition(array, left, right);
        middleQuickSort(array, left, position - 1);
        middleQuickSort(array, position + 1, right);
    }

    public static void main(String[] args) {
        //Integer[] array = {3, 2, 1, 5, 4};
        int size = 100000;
        System.out.println("========== RandomArray Test ============");// RandomArray Test
        Integer[] array = ArrayGenerator.generateRandomArray(size, size);
        Integer[] array2 = array.clone();
        SortTimeHelper.sortTimeCost(array, "QuickSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSortWithCopiedArray", 0, array2.length - 1);


        // Order Array Test
//        array = ArrayGenerator.generateOrderedArray(size);
//        array2 = array.clone();
        // Stackoverflow
//        SortTimeHelper.sortTimeCost(array, "RandomQuickSort", 0, array.length - 1);
//        SortTimeHelper.sortTimeCost(array2, "MergeSortWithCopiedArray", 0, array2.length - 1);

        System.out.println("========== Special Array Test ============");// Special Array Test
        array = ArrayGenerator.generateRandomSpecialArray(size);
        array2 = array.clone();
        Integer[] array3 = array.clone();
        SortTimeHelper.sortTimeCost(array, "RandomQuickSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSortWithCopiedArray", 0, array2.length - 1);
        // Super Slow
        SortTimeHelper.sortTimeCost(array3, "MiddleQuickSort", 0, array.length - 1);

        System.out.println("========== 2ways QuickSort Test ============");
        array = ArrayGenerator.generateRandomArray(size, size);
        array2 = array.clone();
        SortTimeHelper.sortTimeCost(array, "QuickSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "QuickSort2Ways", 0, array.length - 1);
    }
}
