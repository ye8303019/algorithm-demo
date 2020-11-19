package com.chris.algorithm.demo.leetcode.probelm_493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ye830 on 11/19/2020.
 * <p>
 * Description:
 * Leetcode 493
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * You need to return the number of important reverse pairs in the given array.
 *
 * @author Chris Ye
 */
public class Solution {
    public static int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    private static int reversePairs(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int result = 0;
        int middle = left + ((right - left) / 2);
        result += reversePairs(array, left, middle);
        result += reversePairs(array, middle + 1, right);

        int i = middle;
        int j = right;

        while (i >= left) {
            while (j > middle && array[i] > array[j] * 2L) {
                j--;
            }
            result += right - j;
            i--;
        }

        i = left;
        j = middle + 1;
        int index = 0;
        int[] temp = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (array[i] > array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }
        while (i <= middle) {
            temp[index++] = array[i++];
        }
        while (j <= right) {
            temp[index++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, right - left + 1);

        return result;
    }

    public static void main(String[] args) {
//        int[] array = new int[4];
//        int i = 0;
//        try {
//            InputStreamReader read = new InputStreamReader(new FileInputStream("C:\\development\\IdeaProjects\\algorithm-demo\\src\\main\\java\\com\\chris\\algorithm\\demo\\leetcode\\probelm_493\\TestCase"), "UTF-8");
//            BufferedReader in = new BufferedReader(read);
//            String str;
//            while ((str = in.readLine()) != null) {
//                str = str.replace(",","");
//                array[i] = Integer.valueOf(str);
//                i++;
//            }
//        } catch (IOException e) {
//        }

        int[] array = {10, 15, 4, 6};

// [233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004]
//        int size = 61;
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = size - i;
//        }
        System.out.println(reversePairs(array));
    }
}
