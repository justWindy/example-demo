package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-21
 * Time: 20:57
 */
public class LinkListPartitionClass {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        int index = 0;
        while (current != null) {
            index++;
            if (current.val == x) {
                break;
            }
            current = current.next;
        }

        if (current == null) {
            if (index == 1) {
                return head;
            }
            current = head;
            while (current != null) {
                if (current.val > x) {
                    break;
                }
                current = current.next;
            }

            if (current == null) {
                return head;
            }
        }

        ListNode p1, p2, p3, p4, p5 = null, p6 = null;

        p1 = p2 = head;
        p3 = current;
        p4 = p3.next;
        while (p2 != null) {

            if (p2.val < x) {
                p2 = p2.next;
            } else {
                if (p4 == null) {
                    p3 = current;
                    if (p3 == p2.next || p3 == p2 || p3 == p6) {
                        break;
                    }
                    if (p5 == null) {
                        p5 = p2.next;
                    }
                    if (p6 == null) {
                        p6 = p2;
                    }
                    if (p5.val < x) {
                        if (p1 == head) {
                            p2.next = p5.next;
                            p5.next = p1;
                            head = p5;
                        } else {
                            p1.next = p5;
                            p6.next = p5.next;
                            p5.next = p2;
                        }
                    } else {
                        p5 = p5.next;
                        p6 = p6.next;
                    }
                    continue;
                }
                if (p4.val < x) {
                    if (current == head) {
                        p3.next = p4.next;
                        head = p4;
                        head.next = current;
                    } else {
                        p3.next = p4.next;
                        p1.next = p4;
                        p4.next = p2;
                        p1 = p1.next;
                    }
                    p4 = p3.next;
                } else {
                    p4 = p4.next;
                    p3 = p3.next;
                }
            }

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
        ListNode node = partition(node9, 3);
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
