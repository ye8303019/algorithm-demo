package com.chris.algorithm.demo.Sort;

/**
 * Created by ye830 on 11/9/2020.
 */
public class BubbleSort {
    public void sort(Integer[] array) {
        System.out.println(arrayToStr(array));
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    Integer value = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = value;
                }
            }
        }
        System.out.println(arrayToStr(array));
    }

    private String arrayToStr(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(String.valueOf(array[i]));
            if(i != array.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] array = {0, 2, 4, 1, 10, 5, 6, 8};
        new BubbleSort().sort(array);
    }
}
