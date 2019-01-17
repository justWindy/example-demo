package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-13
 * Time: 14:47
 */
public class PrintTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(5);
        TreeNode left21 = new TreeNode(7);
        TreeNode right12 = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;
        left12.left = left21;
        right.right = right12;

        System.out.println(new PrintTree().printCurrentTree(root));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if (pRoot == null) {
            return listAll;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        java.util.Stack<TreeNode> stack1 = new java.util.Stack<>();
        stack.push(pRoot);
        while (!stack.isEmpty() || !stack1.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pNode = stack.pop();
                list.add(pNode.val);
                if (pNode.left != null) {
                    stack1.push(pNode.left);
                }
                if (pNode.right != null) {
                    stack1.push(pNode.right);
                }
            }
            if (!list.isEmpty()) {
                listAll.add(list);
            }

            ArrayList<Integer> list1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode pNode1 = stack1.pop();
                list1.add(pNode1.val);
                if (pNode1.right != null) {
                    stack.push(pNode1.right);
                }

                if (pNode1.left != null) {
                    stack.push(pNode1.left);
                }

            }
            if (!list1.isEmpty()) {
                listAll.add(list1);
            }
        }

        return listAll;
    }

    public ArrayList<ArrayList<Integer>> printCurrentTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if (pRoot == null) {
            return listAll;
        }

        java.util.ArrayDeque<TreeNode> deque = new java.util.ArrayDeque<>();
        java.util.ArrayDeque<TreeNode> deque1 = new java.util.ArrayDeque<>();

        deque.addLast(pRoot);
        while (!deque.isEmpty() || !deque1.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode pNode = deque.pollFirst();
                list.add(pNode.val);
                if (pNode.left != null) {
                    deque1.addLast(pNode.left);
                }

                if (pNode.right != null) {
                    deque1.addLast(pNode.right);
                }
            }
            if (!list.isEmpty()) {
                listAll.add(list);
            }

            ArrayList<Integer> list1 = new ArrayList<>();
            while (!deque1.isEmpty()) {
                TreeNode pNode1 = deque1.pollFirst();
                list1.add(pNode1.val);
                if (pNode1.left != null) {
                    deque.addLast(pNode1.left);
                }

                if (pNode1.right != null) {
                    deque.addLast(pNode1.right);
                }
            }
            if (!list1.isEmpty()) {
                listAll.add(list1);
            }
        }

        return listAll;
    }

    private static class TreeNode {

        int      val   = 0;
        TreeNode left  = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
