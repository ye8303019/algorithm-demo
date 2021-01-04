package com.chris.algorithm.demo.leetcode.problem_704;

/**
 * Created by ye830 on 1/4/2021.
 */
public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return search(nums, target, left, mid - 1);
        }
        return search(nums, target, mid + 1, right);
    }
}
