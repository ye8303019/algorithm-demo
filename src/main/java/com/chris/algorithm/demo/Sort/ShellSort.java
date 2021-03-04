package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;
import com.chris.algorithm.demo.helper.SortTimeHelper;

/**
 * Shell sort Time complexity is quite special, it's between "O(nlogn) to O(n2)"
 */
public class ShellSort<E extends Comparable<E>> {
    private ShellSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;

        while (h >= 1) {
            // this loop represent how many round of insertion sort needed
            for (int start = 0; start < h; start++) {
                // represent where to start and how long the step is, i is the second position of the array
                for (int i = start + h; i < data.length; i += h) {
                    E value = data[i];
                    int j = i;
                    for (; j - h >= 0 && value.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = value;
                }
            }
            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        int h = data.length / 2;

        while (h >= 1) {
//                represent where to start and how long the step is, the main difference between sort2 and sort is that
//                we not need to wait until we find the next item, we can compare the item in sequence directly
                for (int i = h + h; i < data.length; i ++) {
                    E value = data[i];
                    int j = i;
                    for (; j - h >= 0 && value.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = value;
                }
            h /= 2;
        }
    }

    public static void main(String[] args) {
        int size = 1000000;
        System.out.println("========== RandomArray Test ============");// RandomArray Test
        Integer[] array = ArrayGenerator.generateRandomArray(size, size);
        Integer[] array2 = array.clone();
        Integer[] array3 = array.clone();
        SortTimeHelper.sortTimeCost(array, "ShellSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "ShellSort2", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSort", 0, array3.length - 1);
    }
}
