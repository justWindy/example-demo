package org.xiuyuan.example.algorithms.leetcode;

/**
 * 相交链表
 * <p>
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 16:08
 */
public class LeetCode160 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headA0 = new ListNode(1);
        ListNode headA1 = new ListNode(8);
        ListNode headA2 = new ListNode(4);
        ListNode headA3 = new ListNode(5);

        headA.next = headA0;
        headA0.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;

        ListNode headB = new ListNode(5);
        ListNode headB0 = new ListNode(0);
        ListNode headB1 = new ListNode(1);

        headB.next = headB0;
        headB0.next = headB1;
        headB1.next = headA1;

        LeetCode160 leetCode160 = new LeetCode160();
        ListNode listNode = leetCode160.getInteresectionNode(headA, headB);

        System.out.println();
    }

    public ListNode getInteresectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;

        int lengthA = getLength(head1);
        int lengthB = getLength(head2);

        boolean flag = lengthA > lengthB;
        int length = flag ? lengthA - lengthB : lengthB - lengthA;

        if (flag) {
            head1 = headA;
            for (int i = 0; i < length; i++) {
                head1 = head1.next;
            }
            head2 = headB;
        } else {
            head1 = headB;
            for (int i = 0; i < length; i++) {
                head1 = head1.next;
            }
            head2 = headA;
        }

        while ((head1 != null) && (head2 != null) && (head1 != head2)) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private static class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
