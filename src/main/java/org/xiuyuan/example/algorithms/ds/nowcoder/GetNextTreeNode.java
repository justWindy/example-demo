package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 23:53
 */
public class GetNextTreeNode {

    public static void main(String[] args) {

    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        while (pNode.next != null) {
            if (pNode.next.left.val == pNode.val) {
                return pNode.next;
            }
            pNode = pNode.next;
        }

        return null;
    }

}
