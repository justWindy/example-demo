package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 20:12
 */
public class LeetCode783 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(6);
        TreeNode root11 = new TreeNode(1);
        TreeNode root12 = new TreeNode(3);

        root.left = root1;
        root.right = root2;
        root1.left = root11;
        root1.right = root12;

        LeetCode783 leetCode783 = new LeetCode783();
        System.out.println(leetCode783.minDiffInBST(root));
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        nonRecursive(root, list);

        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i) - list.get(i - 1);
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    private void nonRecursive(TreeNode root, List<Integer> list) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                current = temp.right;
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
