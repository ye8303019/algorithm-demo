package com.chris.algorithm.demo.leetcode;

/**
 * Created by ye830 on 10/29/2020.
 * <p>
 * Description:
 * Leetcode 203
 * Remove all elements from a linked list of integers that have value val.
 *
 * @author Chris Ye
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1, head);

        ListNode prev = dummyHead;

        while (prev != null) {
            if (prev.next != null && prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] array = {1,1};
        ListNode listNode = new ListNode(array);
        System.out.println("Before remove: " + listNode);
        System.out.println("After remove: " + new Solution().removeElements(listNode, 1));
    }
}
