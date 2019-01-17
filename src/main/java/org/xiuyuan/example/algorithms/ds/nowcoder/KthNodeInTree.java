package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-13
 * Time: 17:11
 */
public class KthNodeInTree {

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }

        ArrayList<TreeNode> list = inOrder(pRoot);
        if (list.size() < k) {
            return null;
        }

        return list.get(k - 1);
    }

    public ArrayList<TreeNode> inOrder(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;


        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                list.add(current);
                cur = current.right;
            }
        }

        return list;
    }

    private static class TreeNode {

        int      val   = 0;
        TreeNode left  = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        TreeNode left11 = new TreeNode(2);
        TreeNode left12 = new TreeNode(4);
        TreeNode right11 = new TreeNode(6);
        TreeNode right12 = new TreeNode(8);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;
        right.left = right11;
        right.right = right12;

        new KthNodeInTree().KthNode(root, 3);

    }

}
