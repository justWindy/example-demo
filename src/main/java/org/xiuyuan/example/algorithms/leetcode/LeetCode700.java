package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 23:09
 */
public class LeetCode700 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(7);
        TreeNode root11 = new TreeNode(1);
        TreeNode root12 = new TreeNode(3);

        root.left = root1;
        root.right = root2;
        root1.left = root11;
        root1.right = root12;

        LeetCode700 leetCode700 = new LeetCode700();
        System.out.println(leetCode700.searchBST(root, 2));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        while (current != null) {
            if (current.val == val) {
                break;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
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
