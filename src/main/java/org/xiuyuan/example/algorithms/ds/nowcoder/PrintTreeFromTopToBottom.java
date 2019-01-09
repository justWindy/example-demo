package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-09
 * Time: 17:48
 */
public class PrintTreeFromTopToBottom {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(10);
        TreeNode left11 = new TreeNode(5);
        TreeNode left12 = new TreeNode(7);
        TreeNode right11 = new TreeNode(9);
        TreeNode right12 = new TreeNode(11);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;
        right.left = right11;
        right.right = right12;

        System.out.println(PrintFromTopToBottom(root));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        java.util.ArrayDeque<TreeNode> queue = new java.util.ArrayDeque<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node != null) {
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }

        return list;
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
