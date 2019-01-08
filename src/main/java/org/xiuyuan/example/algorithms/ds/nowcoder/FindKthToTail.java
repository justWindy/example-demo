package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 19:26
 */
public class FindKthToTail {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = findKthToTail(node1, 3);

        System.out.println(node.val);

    }

    public static ListNode findKthToTail(ListNode head, int k) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();

        if (head == null) {
            return null;
        }

        ListNode sentinal = new ListNode(head.val);
        sentinal.next = head.next;

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        if (k > list.size()) {
            return null;
        }


        for (int i = 0; i < list.size() - k; i++) {
            sentinal = sentinal.next;
        }

        return sentinal;
    }

    public static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
