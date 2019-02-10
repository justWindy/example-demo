package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-02-08
 * Time: 23:07
 */
public class LeetCode617 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t11 = new TreeNode(3);
        TreeNode t12 = new TreeNode(2);
        TreeNode t111 = new TreeNode(5);

        t1.left = t11;
        t1.right = t12;
        t11.left = t111;

        TreeNode t2 = new TreeNode(2);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(3);
        TreeNode t212 = new TreeNode(4);
        TreeNode t222 = new TreeNode(7);

        t2.left = t21;
        t2.right = t22;
        t21.right = t212;
        t22.right = t222;

        LeetCode617 leetCode617 = new LeetCode617();
        TreeNode root = leetCode617.mergeTrees(t1, t2);

        System.out.println();
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    private static class TreeNode {

        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
