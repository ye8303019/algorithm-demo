package com.chris.algorithm.demo.helper;

/**
 * Created by ye830 on 11/12/2020.
 */
public class ArrayHelper<E extends Comparable<E>> {
    public static <E extends Comparable<E>> String arrayToStr(E[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(String.valueOf(array[i]));
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
