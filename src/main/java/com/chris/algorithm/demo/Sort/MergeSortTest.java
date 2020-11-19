package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;
import com.chris.algorithm.demo.helper.ArrayHelper;
import com.chris.algorithm.demo.helper.SortTimeHelper;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Created by ye830 on 11/12/2020.
 */
public class MergeSortTest<E extends Comparable<E>> {

    public <E extends Comparable<E>> void mergeSort(E[] array, int left, int right) {
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

    public <E extends Comparable<E>> void mergeSortBU(E[] array, int left, int right, E[] tempArray) {
        if (array == null || left > right) {
            throw new IllegalArgumentException();
        }

        if (left >= right) {
            return;
        }

        int n = array.length;

        // 使用插入排序优化
        // 遍历一遍，对所有 arr[i, i + 15] 的区间，使用插入排序法
        for (int i = 0; i < n; i += 16) {
            InsertionSortTest.sort(array, i, Math.min(n - 1, i + 15));
        }


        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {
            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (array[i + sz - 1].compareTo(array[i + sz]) > 0) {
                    mergeSortWithCopiedArray(array, i, Math.min(i + sz + sz - 1, n - 1), tempArray);
                }
            }
        }
    }

    public <E extends Comparable<E>> void mergeSortOrdered(E[] array, int left, int right) {
        if (array == null || left > right) {
            throw new IllegalArgumentException();
        }

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSortOrdered(array, left, middle);

        mergeSortOrdered(array, middle + 1, right);

        if (array[middle].compareTo(array[middle + 1]) > 0) {
            merge(array, left, middle, right);
        }
    }

    public <E extends Comparable<E>> void mergeSortWithCopiedArray(E[] array, int left, int right, E[] tempArray) {
        if (array == null || left > right) {
            throw new IllegalArgumentException();
        }

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSortOrdered(array, left, middle);

        mergeSortOrdered(array, middle + 1, right);

        if (array[middle].compareTo(array[middle + 1]) > 0) {
            mergeWithCopiedArray(array, left, middle, right, tempArray);
        }
    }

    public <E extends Comparable<E>> void mergeSortCombineInsertedSortWithCopiedArray(E[] array, int left, int right, E[] tempArray) {
        if (array == null || left > right) {
            throw new IllegalArgumentException();
        }

        if (right - left <= 15) {
            InsertionSortTest.sort(array, left, right);
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSortOrdered(array, left, middle);

        mergeSortOrdered(array, middle + 1, right);

        if (array[middle].compareTo(array[middle + 1]) > 0) {
            mergeWithCopiedArray(array, left, middle, right, tempArray);
        }
    }

    private <E extends Comparable<E>> void merge(E[] array, int left, int middle, int right) {
        E[] bufferArray = Arrays.copyOfRange(array, left, right + 1);

        int i = left;
        int j = middle + 1;
        int index = left;

        while (i <= middle || j <= right) {
            if (i > middle && j <= right) {
                array[index] = bufferArray[j - left];
                j++;
            } else if (i <= middle && j > right) {
                array[index] = bufferArray[i - left];
                i++;
            } else if (bufferArray[i - left].compareTo(bufferArray[j - left]) <= 0) {
                array[index] = bufferArray[i - left];
                i++;
            } else if (bufferArray[j - left].compareTo(bufferArray[i - left]) < 0) {
                array[index] = bufferArray[j - left];
                j++;
            }
            index++;
        }
    }


    private <E extends Comparable<E>> void mergeWithCopiedArray(E[] array, int left, int middle, int right, E[] tempArray) {
        int i = left;
        int j = middle + 1;
        int index = left;

        while (i <= middle || j <= right) {
            if (i > middle && j <= right) {
                array[index] = tempArray[j];
                j++;
            } else if (i <= middle && j > right) {
                array[index] = tempArray[i - left];
                i++;
            } else if (tempArray[i].compareTo(tempArray[j]) <= 0) {
                array[index] = tempArray[i - left];
                i++;
            } else if (tempArray[j].compareTo(tempArray[i]) < 0) {
                array[index] = tempArray[j - left];
                j++;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        System.out.println("======================FixedArray===========================");
        Integer[] array = {1, 3, 9, 9, 4, 2, 8, 6};
        System.out.println("Before Array Been Merge Sorted:" + ArrayHelper.arrayToStr(array));
        new MergeSortTest().mergeSort(array, 0, 7);
        System.out.println("After Array Been Merge Sorted:" + ArrayHelper.arrayToStr(array));

        System.out.println("======================RandomArray===========================");

        int size = 5000000;
        array = ArrayGenerator.generateRandomArray(size, size);
        Integer[] array2 = array.clone();
        SortTimeHelper.sortTimeCost(array, "MergeSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSortOrdered", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "MergeSortWithCopiedArray", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "mergeSortCombineInsertedSortWithCopiedArray", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "mergeSortBU", 0, array2.length - 1);

        System.out.println("======================OrderedArray=======================");
        array = ArrayGenerator.generateOrderedArray(size);
        array2 = array.clone();
        SortTimeHelper.sortTimeCost(array, "MergeSort", 0, array.length - 1);
        SortTimeHelper.sortTimeCost(array2, "MergeSortOrdered", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "MergeSortWithCopiedArray", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "mergeSortCombineInsertedSortWithCopiedArray", 0, array2.length - 1);
        SortTimeHelper.sortTimeCost(array, "mergeSortBU", 0, array2.length - 1);

    }
}
