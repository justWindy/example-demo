package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-21
 * Time: 20:57
 */
public class LinkListPartitionClass {

    public static ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode current = head;

        ListNode small, big;
        small = big = null;

        ListNode smallCur, bigCur;
        smallCur = bigCur = null;
        while (current != null) {
            if (current.val < x) {
                if (small == null) {
                    small = current;
                    smallCur = small;
                } else {
                    smallCur.next = current;
                    smallCur = smallCur.next;
                }
            } else {
                if (big == null) {
                    big = current;
                    bigCur = big;
                } else {
                    bigCur.next = current;
                    bigCur = bigCur.next;
                }
            }
            current = current.next;
        }

        if (small != null) {
            head = small;
        } else {
            head = big;
        }


        if (smallCur != null) {
            smallCur.next = big;
        }
        if (bigCur != null) {
            bigCur.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node7.next = node8;

        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        node9.next = node10;
        node10.next = node11;

        ListNode node12 = new ListNode(1);
        ListNode node = partition(node12, 0);
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    private static class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
