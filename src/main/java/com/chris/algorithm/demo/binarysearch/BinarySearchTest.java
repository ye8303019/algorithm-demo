package com.chris.algorithm.demo.binarysearch;

/**
 * Created by ye830 on 1/4/2021.
 */
public class BinarySearchTest {
    public static <E extends Comparable> int binarySearchInRecursive(E[] data, E target) {
        return binarySearchInRecursive(data, target, 0, data.length - 1);
    }

    public static <E extends Comparable> int binarySearchInRecursive(E[] data, E target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) > 0) {
            return binarySearchInRecursive(data, target, left, mid - 1);
        }
        return binarySearchInRecursive(data, target, mid + 1, right);
    }

    public static <E extends Comparable> int binarySearch(E[] data, E target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    public static <E extends Comparable> int binarySearch(E[] data, E target, int left, int right) {
        // 循环不变量为 在 [left, right] 中查找 target
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 6, 7, 8, 9, 10, 15, 18, 19, 20, 21};
        System.out.println("Binary Search In Recursive:" + BinarySearchTest.binarySearchInRecursive(array, 9));
        System.out.println("Binary Search Without Recursive:" + BinarySearchTest.binarySearch(array, 9));
    }
}
