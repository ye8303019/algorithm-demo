package com.chris.algorithm.demo.helper;

import com.chris.algorithm.demo.Sort.BubbleSortTest;
import com.sun.deploy.util.ArrayUtil;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomSpecialArray(int n) {
        Integer[] arr = new Integer[n];
        insertSort(arr, 0, n - 1, 0);
        return arr;
    }

    private static void insertSort(Integer[] arr, int left, int right, int insertValue) {
        if (left > right) {
            return;
        }
        int middle = left + ((right - left) / 2);
        arr[middle] = insertValue;

        SwapHelper.swap(arr, middle, left);

        insertSort(arr, left + 1, right, insertValue + 1);

        SwapHelper.swap(arr, middle, left);

    }

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.generateRandomSpecialArray(7);
        System.out.println(ArrayHelper.arrayToStr(array));
    }
}