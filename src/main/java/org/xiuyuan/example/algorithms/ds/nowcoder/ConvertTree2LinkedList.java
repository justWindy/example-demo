package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 二叉搜索树与双向链表
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 17:53
 */
public class ConvertTree2LinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(14);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(8);
        TreeNode right11 = new TreeNode(12);
        TreeNode right12 = new TreeNode(16);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;
        right.left = right11;
        right.right = right12;

        TreeNode result = new ConvertTree2LinkedList().Convert(root);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        TreeNode[] lastNode = new TreeNode[1];
        convertNode(pRootOfTree, lastNode);

        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }

    public void convertNode(TreeNode root, TreeNode[] lastNode) {

        if (root == null) {
            return;
        }

        TreeNode current = root;

        if (current.left != null) {
            convertNode(current.left, lastNode);
        }

        current.left = lastNode[0];
        if (lastNode[0] != null) {
            lastNode[0].right = current;
        }

        lastNode[0] = current;

        if (current.right != null) {
            convertNode(current.right, lastNode);
        }
    }

    private static class TreeNode {

        int      val   = 0;
        TreeNode left  = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
