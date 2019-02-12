package org.xiuyuan.example.algorithms.leetcode;

/**
 * 二叉搜索树的最近公共祖先
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

        LeetCode235 leetCode235 = new LeetCode235();
        TreeNode treeNode = leetCode235.lowestCommonAncestor(root, root01, root00);

        System.out.println();

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode lower = p;
        TreeNode higher = q;
        if (p.val > q.val) {
            higher = p;
            lower = q;
        }

        return ancestor(root, higher, lower);
    }

    private TreeNode ancestor(TreeNode root, TreeNode high, TreeNode lower) {

        if (root == null) {
            return null;
        }

        if (high.val < root.val) {
            return ancestor(root.left, high, lower);
        } else if (lower.val > root.val) {
            return ancestor(root.right, high, lower);
        } else if (lower.val < root.val && high.val > root.val) {
            return root;
        } else {
            if (root.val == high.val) {
                return high;
            } else {
                return lower;
            }
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
