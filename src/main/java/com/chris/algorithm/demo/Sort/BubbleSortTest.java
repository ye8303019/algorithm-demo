package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayHelper;

/**
 * Created by ye830 on 11/9/2020.
 */
public class BubbleSortTest {
    public void sort(Integer[] array) {
        System.out.println(ArrayHelper.arrayToStr(array));
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    Integer value = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = value;
                }
            }
        }
        System.out.println(ArrayHelper.arrayToStr(array));
    }
    public static void main(String[] args) {
        Integer[] array = {0, 2, 4, 1, 10, 5, 6, 8};
        new BubbleSortTest().sort(array);
    }
}
