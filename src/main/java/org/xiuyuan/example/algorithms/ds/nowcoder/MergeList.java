package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 19:54
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode node = merge(node1, node2);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(0);

        ListNode node = new ListNode(0);
        head.next = node;

        while (list1 != null) {
            ListNode newNode = new ListNode(0);
            node.next = newNode;
            node = node.next;

            if (list2 == null) {
                newNode.val = list1.val;
                list1 = list1.next;
                continue;
            }

            if (list1.val > list2.val) {
                newNode.val = list2.val;
                list2 = list2.next;
            } else {
                newNode.val = list1.val;
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            node.next = list2;
        }


        return head.next.next;

    }

    private static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
