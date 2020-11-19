package com.chris.algorithm.demo.Sort;

import com.chris.algorithm.demo.helper.ArrayGenerator;

import java.util.Arrays;

public class InsertionSortTest {

    private InsertionSortTest(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        for(int i = 0; i < arr.length; i ++){

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){

        for(int i = l; i <= r; i ++){
            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++){
            if(arr[i - 1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }
}
