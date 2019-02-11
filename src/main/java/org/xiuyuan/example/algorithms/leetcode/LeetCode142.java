package org.xiuyuan.example.algorithms.leetcode;

/**
 * 环形链表 II
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 16:02
 */
public class LeetCode142 {

    public static void main(String[] args) {

        LeetCode142 leetCode142 = new LeetCode142();

        ListNode head = new ListNode(3);
        ListNode head0 = new ListNode(2);
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(-4);

        head.next = head0;
        head0.next = head1;
        head1.next = head2;
        head2.next = head0;

        ListNode listNode = leetCode142.detectCycle(head);
        System.out.println();
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if (first == second) {
                second = head;
                while (first != second) {
                    first = first.next;
                    second = second.next;
                }

                return first;
            }
        }

        return null;
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
