package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-09
 * Time: 21:44
 */
public class LinkedListClone {

    public static void main(String[] args) {
        LinkedListClone linkedListClone = new LinkedListClone();

        RandomListNode yiHead = new RandomListNode(1);
        RandomListNode erNode = new RandomListNode(2);
        RandomListNode sanNode = new RandomListNode(3);
        RandomListNode siNode = new RandomListNode(4);
        RandomListNode wuNode = new RandomListNode(5);

        yiHead.next = erNode;
        erNode.next = sanNode;
        sanNode.next = siNode;
        siNode.next = wuNode;

        yiHead.random = sanNode;
        erNode.random = wuNode;
        sanNode.random = null;
        siNode.random = erNode;
        wuNode.random = null;

        RandomListNode newNode = linkedListClone.Clone(yiHead);

        RandomListNode temp1 = newNode;

        while (temp1 != null) {
            System.out.print(temp1.label + " ");
            temp1 = temp1.next;
        }

        System.out.println();

        temp1 = newNode;
        while (temp1 != null) {
            if (temp1.random == null) {
                System.out.print("#" + " ");
            } else {
                System.out.print(temp1.random.label + " ");
            }

            temp1 =temp1.next;
        }

    }

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode oldNode = pHead;

        while (oldNode != null) {
            RandomListNode newNode = new RandomListNode(oldNode.label);
            newNode.next = oldNode.next;
            oldNode.next = newNode;
            oldNode = oldNode.next.next;
        }

        oldNode = pHead;
        while (oldNode != null) {
            if (oldNode.random != null) {
                oldNode.next.random = oldNode.random.next;
            } else {
                oldNode.next.random = null;
            }

            oldNode = oldNode.next.next;
        }

        RandomListNode tempNewNode = new RandomListNode(0);
        RandomListNode curNewNode = tempNewNode;
        oldNode = pHead;

        while (oldNode != null) {
            tempNewNode.next = oldNode.next;
            tempNewNode = oldNode.next;

            oldNode.next = tempNewNode.next;
            oldNode = oldNode.next;
        }

        return curNewNode.next;
    }

}
