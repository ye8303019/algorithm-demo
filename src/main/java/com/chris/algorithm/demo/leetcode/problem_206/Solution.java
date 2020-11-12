package com.chris.algorithm.demo.leetcode.problem_206;

import com.chris.algorithm.demo.leetcode.problem_203.ListNode;

/**
 * Created by ye830 on 11/9/2020.
 *
 * @author Chris Ye
 *
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,4,5,6,7,8};
        ListNode listNode = new ListNode(array);
        System.out.println(listNode);
        listNode = reverseList(listNode);
        System.out.println(listNode);
    }
}
