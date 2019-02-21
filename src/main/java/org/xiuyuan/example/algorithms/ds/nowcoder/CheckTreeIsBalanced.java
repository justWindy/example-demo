package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 二叉树的深度
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 16:24
 */
public class CheckTreeIsBalanced {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(5);
        TreeNode left21 = new TreeNode(7);
        TreeNode right12 = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;
        left12.left = left21;
//        right.right = right12;

        boolean result = new CheckTreeIsBalanced().isBalance_solution(root);

        System.out.println(result);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

    private boolean isBalance_solution(TreeNode root) {
        int[] depth = new int[1];
        return isBalance(root, depth);
    }

    private boolean isBalance(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalance(root.left, left) && isBalance(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }

        return false;
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
