package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 23:22
 */
public class LeetCode235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(8);
        TreeNode root00 = new TreeNode(0);
        TreeNode root01 = new TreeNode(4);
        TreeNode root10 = new TreeNode(7);
        TreeNode root11 = new TreeNode(9);
        TreeNode root010 = new TreeNode(3);
        TreeNode root011 = new TreeNode(5);

        root.left = root0;
        root.right = root1;
        root0.left = root00;
        root0.right = root01;
        root1.left = root10;
        root1.right = root11;
        root01.left = root010;
        root01.right = root011;
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
