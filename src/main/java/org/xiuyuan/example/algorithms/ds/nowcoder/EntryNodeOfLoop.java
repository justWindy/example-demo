package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 19:39
 */
public class EntryNodeOfLoop {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node4;


        ListNode result = EntryNodeOfLoop(node1);

        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode pFirst = pHead;
        ListNode pSecond = pHead;

        while (pSecond != null && pSecond.next != null) {
            pFirst = pFirst.next;
            pSecond = pSecond.next.next;
            if (pFirst.val == pSecond.val && pFirst.next == pSecond.next) {
                pSecond = pHead;
                while (pFirst.val != pSecond.val) {
                    pFirst = pFirst.next;
                    pSecond = pSecond.next;
                }
                if (pFirst.next == pSecond.next) {
                    return pFirst;
                }
            }
        }

        return null;
    }

}
