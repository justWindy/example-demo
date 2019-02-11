package org.xiuyuan.example.algorithms.leetcode;

/**
 * 验证二叉搜索树
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 20:27
 */
public class LeetCode98 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root0 = new TreeNode(1);
        TreeNode root1 = new TreeNode(5);
        TreeNode root00 = new TreeNode(0);
        TreeNode root01 = new TreeNode(2);
        TreeNode root10 = new TreeNode(4);
        TreeNode root11 = new TreeNode(6);
        TreeNode root011 = new TreeNode(3);
        root.left = root0;
        root.right = root1;
        root0.left = root00;
        root0.right = root01;
        root1.left = root10;
        root1.right = root11;
        root01.right = root011;

        TreeNode other = new TreeNode(98);
        TreeNode other0 = new TreeNode(-15);
        TreeNode other01 = new TreeNode(58);
        TreeNode other010 = new TreeNode(31);

        other.left = other0;
        other0.right = other01;
        other01.left = other010;

        LeetCode98 leetCode98 = new LeetCode98();

        TreeNode kafka = new TreeNode(Integer.MIN_VALUE);
        kafka.left = new TreeNode(Integer.MIN_VALUE);

        System.out.println(leetCode98.isValidBST(kafka));
    }

    public boolean isValidBST(TreeNode root) {

        int[] val = new int[1];
        int[] flag = new int[1];

        val[0] = Integer.MIN_VALUE;
        flag[0] = 1;

        return isValidBST(root, val, flag);

    }

    private boolean isValidBST(TreeNode root, int[] val, int[] flag) {
        if (root == null) {
            return true;
        }

        if (isValidBST(root.left, val, flag)) {
            if (root.val > val[0] || (flag[0] == 1 && root.val == Integer.MIN_VALUE)) {
                val[0] = root.val;
                flag[0] = 0;
                return isValidBST(root.right, val, flag);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private static class TreeNode {

        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
