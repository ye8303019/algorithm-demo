package com.chris.algorithm.demo.leetcode.probelm_493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ye830 on 11/19/2020.
 *
 * @author Chris Ye
 */
public class SlowSolution {
    public static int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] * 2L) {
                    result++;
                }
            }
        }
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

        int[] array = {233,2000000001,234,2000000006,235,2000000003,236,2000000007,237};
//        int size = 61;
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = size - i;
//        }
        System.out.println(reversePairs(array));
    }
}
