package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 19:43
 */
public class ReverseList {

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

        ListNode result = reverseList(node1);

        System.out.println(result.val);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        java.util.Stack<ListNode> stack = new java.util.Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode tail = stack.pop();
        ListNode newHead = new ListNode(0);
        newHead.next = tail;
        while (!stack.isEmpty()) {
            tail.next = stack.pop();
            tail = tail.next;
        }
        tail.next = null;

        return newHead.next;
    }

    private static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
