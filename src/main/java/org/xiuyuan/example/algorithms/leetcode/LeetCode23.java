package org.xiuyuan.example.algorithms.leetcode;

/**
 * 合并K个排序链表
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 18:08
 */
public class LeetCode23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l10 = new ListNode(4);
        ListNode l11 = new ListNode(5);
        l1.next = l10;
        l10.next = l11;

        ListNode l2 = new ListNode(1);
        ListNode l20 = new ListNode(3);
        ListNode l21 = new ListNode(4);
        l2.next = l20;
        l20.next = l21;

        ListNode l3 = new ListNode(2);
        ListNode l30 = new ListNode(6);
        l3.next = l30;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;

        LeetCode23 leetCode23 = new LeetCode23();

        ListNode node = leetCode23.mergeKLists(listNodes);

        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int length = lists.length;
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = merge2List(lists[i], lists[i + (length + 1) / 2]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        ListNode first = l1;
        ListNode second = l2;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }

        return head.next;
    }

    private static class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
