package com.chris.algorithm.demo.leetcode.problem_203;

/**
 * Created by ye830 on 10/29/2020.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] array) {
        this(array[0]);
        ListNode cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode listNode = this; listNode != null; listNode = listNode.next) {
            sb.append(listNode.val + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
