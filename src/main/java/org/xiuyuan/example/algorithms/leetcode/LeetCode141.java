package org.xiuyuan.example.algorithms.leetcode;

/**
 * 环形链表
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 17:19
 */
public class LeetCode141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head0 = new ListNode(2);
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(-4);

        head.next = head0;
        head0.next = head1;
        head1.next = head2;
        head2.next = head0;

        LeetCode141 leetCode141 = new LeetCode141();

        System.out.println(leetCode141.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;

            if (low == fast) {
                return true;
            }
        }

        return false;
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
