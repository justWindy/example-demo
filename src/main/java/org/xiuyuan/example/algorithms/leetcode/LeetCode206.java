package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * 反转链表
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 17:50
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head0 = new ListNode(2);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(5);

        head.next = head0;
        head0.next = head1;
        head1.next = head2;
        head2.next = head3;

        LeetCode206 leetCode206 = new LeetCode206();
        ListNode listNode = leetCode206.reverseList(head);

        System.out.println();
    }

    private static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = new ListNode(0);
        ListNode prev = head.next;

        if (prev == null) {
            return head;
        }

        tail.next = head;
        head.next = null;

        while (prev != null) {
            ListNode current = new ListNode(prev.val);
            ListNode temp = tail.next;
            tail.next = current;
            current.next = temp;
            prev = prev.next;
        }

        return tail.next;
    }

    public ListNode reverseList(ListNode head) {

        ListNode node = head;

        Stack<ListNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode current = new ListNode(1);
        node = current;

        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }

        return current.next;
    }

}
