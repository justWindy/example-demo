package org.xiuyuan.example.algorithms.leetcode;

/**
 * 排序链表
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 15:33
 */
public class LeetCode148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode head0 = new ListNode(5);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(0);

        head.next = head0;
        head0.next = head1;
        head1.next = head2;
        head2.next = head3;

        LeetCode148 leetCode148 = new LeetCode148();

        ListNode listNode = leetCode148.sortList(head);

        System.out.println();
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        return mergeSort(head);

    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode current = head, suc = head, pre = null;

        while (suc != null && suc.next != null) {
            pre = current;
            current = current.next;
            suc = suc.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(current);

        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l != null || r != null) {
            if (l != null && r != null) {
                if (l.val >= r.val) {
                    current.next = r;
                    r = r.next;
                } else {
                    current.next = l;
                    l = l.next;
                }
            } else if (l != null) {
                current.next = l;
                l = l.next;
            } else {
                current.next = r;
                r = r.next;
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
