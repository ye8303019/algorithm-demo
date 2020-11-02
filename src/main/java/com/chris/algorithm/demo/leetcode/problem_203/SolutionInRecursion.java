package com.chris.algorithm.demo.leetcode.problem_203;

/**
 * Created by ye830 on 10/29/2020.
 * <p>
 * Description:
 * Leetcode 203
 * Remove all elements from a linked list of integers that have value val.
 *
 * @author Chris Ye
 */
public class SolutionInRecursion {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //这句话的语义代表返回删除后的链表，并赋值给当前节点的下一段链表，因为后续会判断是否返回后面一段，还是直接返回当前节点
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        //int[] array = {1, 1};
        int[] array = {1, 2, 3, 6, 4, 5, 6, 6, 6, 7};
        ListNode listNode = new ListNode(array);
        System.out.println("Before remove: " + listNode);
        System.out.println("After remove: " + new SolutionInRecursion().removeElements(listNode, 6));
    }
}
