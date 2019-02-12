package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层次遍历 II
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 12:16
 */
public class LeetCode107 {

    public static void main(String[] args) {

        LeetCode107 leetCode107 = new LeetCode107();
        TreeNode root = new TreeNode(3);
        TreeNode root0 = new TreeNode(9);
        TreeNode root1 = new TreeNode(20);
        TreeNode root10 = new TreeNode(15);
        TreeNode root11 = new TreeNode(7);

        root.left = root0;
        root.right = root1;
        root1.left = root10;
        root1.right = root11;

        System.out.println(leetCode107.levelOrderBottom(root));

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();

        deque1.offerLast(root);

        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            while (!deque1.isEmpty()) {
                TreeNode node = deque1.pollFirst();
                if (node.left != null) {
                    deque2.offerLast(node.left);
                }

                if (node.right != null) {
                    deque2.offerLast(node.right);
                }
                list1.add(node.val);
            }
            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            List<Integer> list2 = new ArrayList<>();
            while (!deque2.isEmpty()) {
                TreeNode node = deque2.pollFirst();
                if (node.left != null) {
                    deque1.offerLast(node.left);
                }

                if (node.right != null) {
                    deque1.offerLast(node.right);
                }

                list2.add(node.val);
            }
            if (!list2.isEmpty()) {
                lists.add(list2);
            }
        }

        int i=0;
        int j = lists.size() - 1;

        while (i < j) {
            List<Integer> temp = lists.get(i);
            lists.set(i, lists.get(j));
            lists.set(j, temp);
            i++;
            j--;
        }

        return lists;
    }

    private static class TreeNode {

        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
