package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 22:53
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(68);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(58);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(printListFromTailToHead(node1));

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (listNode == null) {
            return list;
        }

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }



        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        return list;
    }

    public static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
