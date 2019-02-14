package org.xiuyuan.example.algorithms.leetcode;

/**
 * 二叉树的坡度
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 19:51
 */
public class LeetCode563 {

    private int tiltTotal = 0;

    public static void main(String[] args) {
        LeetCode563 leetCode563 = new LeetCode563();

        TreeNode root = new TreeNode(1);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(3);
        TreeNode root11 = new TreeNode(5);

        root.left = root0;
        root.right = root1;
        root0.left = new TreeNode(4);
        root1.left = root11;

        System.out.println(leetCode563.findTilt(root));
    }

    public int findTilt(TreeNode root) {
        /*if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        findTilt(root, count);
        return count[0];*/
        findSubTilt(root);

        return tiltTotal;
    }

    private int findTilt(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }

        int leftTilt = findTilt(root.left, count);
        int rightTilt = findTilt(root.right, count);

        count[0] = Math.abs(leftTilt - rightTilt);

        return root.val + leftTilt + rightTilt;
    }

    public int findSubTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTilt = findSubTilt(root.left);
        int rightTilt = findSubTilt(root.right);
        tiltTotal += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
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
