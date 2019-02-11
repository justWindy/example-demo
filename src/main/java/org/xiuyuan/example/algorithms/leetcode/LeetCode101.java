package org.xiuyuan.example.algorithms.leetcode;

/**
 * 对称二叉树
 * <p>
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 22:08
 */
public class LeetCode101 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(2);
        TreeNode root00 = new TreeNode(3);
        TreeNode root01 = new TreeNode(4);
        TreeNode root10 = new TreeNode(4);
        TreeNode root11 = new TreeNode(3);

        root.left = root0;
        root.right = root1;
        root0.left = root00;
        root0.right = root01;
        root1.left = root10;
        root1.right = root11;

        LeetCode101 leetCode101 = new LeetCode101();
        System.out.println(leetCode101.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode copy = copy(root);
        TreeNode mirror = mirror(root);

        return checkMirror(mirror, copy);
    }

    public boolean checkMirror(TreeNode treeNode, TreeNode copy) {

        if (treeNode == null && copy == null) {
            return true;
        }

        if (treeNode != null && copy == null) {
            return false;
        }

        if (treeNode == null) {
            return false;
        }

        if (treeNode.val != copy.val) {
            return false;
        }

        return checkMirror(treeNode.left, copy.left) && checkMirror(treeNode.right, copy.right);
    }

    public TreeNode mirror(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode left = mirror(treeNode.right);
        TreeNode right = mirror(treeNode.left);

        treeNode.left = left;
        treeNode.right = right;

        return treeNode;
    }

    public TreeNode copy(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        TreeNode root = new TreeNode(treeNode.val);
        root.left = copy(treeNode.left);
        root.right = copy(treeNode.right);

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
