package org.xiuyuan.example.algorithms.leetcode;

/**
 * 翻转二叉树
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 19:58
 */
public class LeetCode226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(7);
        TreeNode root00 = new TreeNode(1);
        TreeNode root01 = new TreeNode(3);
        TreeNode root10 = new TreeNode(6);
        TreeNode root11 = new TreeNode(9);

        root.left = root0;
        root.right = root1;
        root0.left = root00;
        root0.right = root01;
        root1.left = root10;
        root1.right = root11;

        LeetCode226 leetCode226 = new LeetCode226();

        TreeNode treeNode = leetCode226.invertTree(root);

        System.out.println();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;

        return root;
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
