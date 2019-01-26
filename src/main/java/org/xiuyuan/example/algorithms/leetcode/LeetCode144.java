package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 19:55
 */
public class LeetCode144 {

    public static void main(String[] args) {
        LeetCode144 leetCode144 = new LeetCode144();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.right = right;
        right.left = right1;

        System.out.println(leetCode144.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        nonRecursive(root, list);

        return list;
    }

    private void recursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        recursive(root.left, list);
        recursive(root.right, list);
    }

    private void nonRecursive(TreeNode root, List<Integer> list) {
        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                list.add(current.val);
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
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
