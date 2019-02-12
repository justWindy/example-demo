package org.xiuyuan.example.algorithms.leetcode;

/**
 * 二叉树展开为链表
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 11:43
 */
public class LeetCode114 {

    public static void main(String[] args) {
        LeetCode114 leetCode114 = new LeetCode114();

        TreeNode root = new TreeNode(1);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(5);
        TreeNode root00 = new TreeNode(3);
        TreeNode root01 = new TreeNode(4);
        TreeNode root11 = new TreeNode(6);

        root.left = root0;
        root.right = root1;
        root0.left = root00;
        root0.right = root01;
        root1.right = root11;

        leetCode114.flatten(root);

        System.out.println();
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            TreeNode right = root.right;

            root.right = root.left;
            root.left = null;

            TreeNode node = root.right;
            while (node.right != null) {
                node = node.right;
            }

            node.right = right;
        }
    }

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
