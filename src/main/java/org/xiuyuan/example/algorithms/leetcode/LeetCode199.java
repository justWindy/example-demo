package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的右视图
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 18:41
 */
public class LeetCode199 {

    public static void main(String[] args) {

        LeetCode199 leetCode199 = new LeetCode199();

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

        System.out.println(leetCode199.rightSideView(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();

        deque1.offerLast(root);

        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            TreeNode currentNode = null;
            while (!deque1.isEmpty()) {
                currentNode = deque1.pollFirst();
                if (currentNode.left != null) {
                    deque2.offerLast(currentNode.left);
                }

                if (currentNode.right != null) {
                    deque2.offerLast(currentNode.right);
                }
            }

            if (currentNode != null) {
                list.add(currentNode.val);
            }

            currentNode = null;
            while (!deque2.isEmpty()) {
                currentNode = deque2.pollFirst();
                if (currentNode.left != null) {
                    deque1.offerLast(currentNode.left);
                }

                if (currentNode.right != null) {
                    deque1.offerLast(currentNode.right);
                }
            }

            if (currentNode != null) {
                list.add(currentNode.val);
            }
        }

        return list;
    }


}
