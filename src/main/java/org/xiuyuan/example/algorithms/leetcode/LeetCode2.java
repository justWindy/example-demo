package org.xiuyuan.example.algorithms.leetcode;

/**
 * 两数相加
 *
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 15:05
 */
public class LeetCode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l10 = new ListNode(4);
        ListNode l11 = new ListNode(3);

        l1.next = l10;
        l10.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l20 = new ListNode(6);
        ListNode l21 = new ListNode(4);

        l2.next = l20;
        l20.next = l21;

        LeetCode2 leetCode2 = new LeetCode2();

        ListNode listNode = leetCode2.addTwoNumbers(l1, l2);

        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null || l2 != null) {

            ListNode node = new ListNode(0);
            if (l1 != null && l2 != null) {
                node.val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                node.val = l1.val;
                l1 = l1.next;
            } else {
                node.val = l2.val;
                l2 = l2.next;
            }
            current.next = node;
            current = current.next;
        }

        current = head.next;

        while (current != null) {
            if (current.val >= 10) {
                current.val = current.val % 10;
                if (current.next != null) {
                    current.next.val += 1;
                } else {
                    current.next = new ListNode(1);
                }
            }
            current = current.next;
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
