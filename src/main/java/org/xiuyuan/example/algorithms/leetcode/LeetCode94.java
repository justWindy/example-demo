package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 17:50
 */
public class LeetCode94 {

    public static void main(String[] args) {
        LeetCode94 leetCode94 = new LeetCode94();

        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.right = right;
        right.left = right1;

        System.out.println(leetCode94.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        noRecursion(root, list);

        return list;
    }

    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);
    }

    private void noRecursion(TreeNode root, List<Integer> list) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                if (temp != null) {
                    list.add(temp.val);
                    current = temp.right;
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
