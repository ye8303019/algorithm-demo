package com.chris.algorithm.demo.arraydemo;

/**
 * Created by ye830 on 11/2/2020.
 *
 * @author Chris Ye
 */
public class ArraySum {
    public static int sum(int[] array, int index){
        if(index == array.length){
            return 0;
        }
        return array[index] + sum(array, index+1);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(sum(array, 0));
    }
}
