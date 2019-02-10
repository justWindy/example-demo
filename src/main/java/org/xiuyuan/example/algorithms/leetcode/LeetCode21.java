package org.xiuyuan.example.algorithms.leetcode;

/**
 * 合并两个有序链表
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 17:28
 */
public class LeetCode21 {

    public static void main(String[] args) {

        LeetCode21 leetCode21 = new LeetCode21();

        ListNode l1 = new ListNode(1);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);

        l1.next = l10;
        l10.next = l11;

        ListNode l2 = new ListNode(1);
        ListNode l20 = new ListNode(3);
        ListNode l21 = new ListNode(4);

        l2.next = l20;
        l20.next = l21;

        ListNode listNode = leetCode21.mergeTwoLists(l1, l2);

        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                current.next = head2;
                head2 = head2.next;
                current = current.next;
            } else {
                if (head2 == null) {
                    current.next = head1;
                    head1 = head1.next;
                    current = current.next;
                } else {
                    if (head1.val <= head2.val) {
                        current.next = head1;
                        head1 = head1.next;
                        current = current.next;
                    } else {
                        current.next = head2;
                        head2 = head2.next;
                        current = current.next;
                    }
                }
            }
        }

        return head.next;
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
