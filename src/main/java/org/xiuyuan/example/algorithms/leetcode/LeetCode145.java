package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 21:09
 */
public class LeetCode145 {

    public static void main(String[] args) {
        LeetCode145 leetCode145 = new LeetCode145();

        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root21 = new TreeNode(3);

        root.right = root2;
        root2.left = root21;

        System.out.println(leetCode145.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {

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
        recursive(root.left, list);
        recursive(root.right, list);
        list.add(root.val);
    }

    private void nonRecursive(TreeNode root, List<Integer> list) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if ((current.left == null && current.right == null) ||
                (pre != null && (pre == current.left || pre == current.right))) {
                list.add(current.val);
                pre = current;
                stack.pop();
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
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
