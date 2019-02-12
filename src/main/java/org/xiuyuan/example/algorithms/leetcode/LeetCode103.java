package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 09:57
 */
public class LeetCode103 {

    public static void main(String[] args) {
        LeetCode103 leetCode103 = new LeetCode103();

        TreeNode root = new TreeNode(3);
        TreeNode root0 = new TreeNode(9);
        TreeNode root1 = new TreeNode(20);
        TreeNode root10 = new TreeNode(15);
        TreeNode root11 = new TreeNode(7);

        root.left = root0;
        root.right = root1;
        root1.left = root10;
        root1.right = root11;

        System.out.println(leetCode103.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();

        stack1.push(root);

        while (!stack.isEmpty() || !stack1.isEmpty()) {

            List<Integer> list1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();

                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }

                list1.add(node.val);
            }
            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            List<Integer> list2 = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();

                if (node.right != null) {
                    stack1.push(node.right);
                }

                if (node.left != null) {
                    stack1.push(node.left);
                }

                list2.add(node.val);
            }

            if (!list2.isEmpty()) {
                lists.add(list2);
            }
        }

        return lists;
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
