package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 22:07
 */
public class LeetCode102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root21;
        root2.right = root22;

        LeetCode102 leetCode102 = new LeetCode102();
        System.out.println(leetCode102.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        ArrayDeque<TreeNode> first = new ArrayDeque<>();
        ArrayDeque<TreeNode> second = new ArrayDeque<>();

        first.addLast(root);
        while (!first.isEmpty() || !second.isEmpty()) {

            ArrayList<Integer> list1 = new ArrayList<>();

            while (!first.isEmpty()) {
                TreeNode current = first.pollFirst();
                list1.add(current.val);

                if (current.left != null) {
                    second.addLast(current.left);
                }

                if (current.right != null) {
                    second.addLast(current.right);
                }
            }

            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            ArrayList<Integer> list2 = new ArrayList<>();

            while (!second.isEmpty()) {

                TreeNode current = second.pollFirst();
                list2.add(current.val);

                if (current.left != null) {
                    first.addLast(current.left);
                }

                if (current.right != null) {
                    first.addLast(current.right);
                }
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
