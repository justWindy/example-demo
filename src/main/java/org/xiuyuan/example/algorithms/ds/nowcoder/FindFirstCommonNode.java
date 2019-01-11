package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 15:26
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node.next = node1;
        node1.next = node2;
        node2.next = node6;
        node6.next = node7;
        node4.next = node5;
        node5.next = node6;

        ListNode result = new FindFirstCommonNode().FindFirstCommonNode(node1, node4);

        System.out.println(result.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);

        boolean flag = length1 > length2;

        int length = flag ? (length1 - length2) : (length2 - length1);

        ListNode pNode = null;
        ListNode pNodeOther = null;

        if (flag) {
            pNode = pHead1;
            for (int i = 0; i < length; i++) {
                pNode = pNode.next;
            }
            pNodeOther = pHead2;
        } else {
            pNode = pHead2;
            for (int i = 0; i < length; i++) {
                pNode = pNode.next;
            }
            pNodeOther = pHead1;
        }

        while ((pNode != null) && (pNodeOther != null) && (pNode.val != pNodeOther.val)) {
            pNode = pNode.next;
            pNodeOther = pNodeOther.next;
        }

        return pNode;
    }

    private int getListLength(ListNode pHead) {
        int length = 0;
        ListNode pNode = pHead;

        while (pNode != null) {
            pNode = pNode.next;
            length++;
        }

        return length;
    }

    private static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
