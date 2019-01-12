package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 20:23
 */
public class DeleteDuplicationClass {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = deleteDuplication(node1);

        System.out.println();
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode pFirst = pHead;

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        while (pFirst != null) {
            if (map.containsKey(pFirst.val)) {
                map.put(pFirst.val, map.get(pFirst.val) + 1);
            } else {
                map.put(pFirst.val, 1);
            }

            pFirst = pFirst.next;
        }


        ListNode pFir = pHead;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ListNode pCur = pHead;
                ListNode pSec = pHead;
                while (pSec != null) {
                    if (pFir == null) {
                        return null;
                    } else {
                        if (pFir.val == entry.getKey()) {
                            pFir = pFir.next;
                        }
                    }
                    if (pSec.val == entry.getKey()) {
                        pCur.next = pSec.next;
                    } else {
                        pCur = pSec;
                    }
                    pSec = pSec.next;
                }
            }
        }


        return pFir;
    }

    private static class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
