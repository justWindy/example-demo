package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 22:44
 */
public class LeetCode111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root21;
        root2.right = root22;

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);

        node.right = node1;

        LeetCode111 leetCode111 = new LeetCode111();
        System.out.println(leetCode111.minDepth(node));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return left != 0 && right != 0 ? 1 + Math.min(left, right) : 1 + left + right;
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
