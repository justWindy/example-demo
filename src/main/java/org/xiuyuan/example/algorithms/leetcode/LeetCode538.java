package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * 把二叉搜索树转换为累加树
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 20:53
 */
public class LeetCode538 {

    private int preNum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root0 = new TreeNode(2);
        TreeNode root1 = new TreeNode(13);

        root.left = root0;
        root.right = root1;

        LeetCode538 leetCode538 = new LeetCode538();
        TreeNode treeNode = leetCode538.iterateConvertBST(root);

        System.out.println();
    }

    public TreeNode iterateConvertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            current.val += preNum;
            preNum = current.val;

            if (current.left != null) {
                current = current.left;
            } else {
                current = null;
            }
        }

        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        unpreOrder(root);

        return root;
    }

    private void unpreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        unpreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unpreOrder(root.left);
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
