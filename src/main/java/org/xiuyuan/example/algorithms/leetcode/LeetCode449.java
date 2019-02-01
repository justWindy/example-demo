package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 17:03
 */
public class LeetCode449 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root21 = new TreeNode(4);
        TreeNode root22 = new TreeNode( 5);

        root.left = root1;
        root.right = root2;

        root2.left = root21;
        root2.right = root22;

        LeetCode449 leetCode449 = new LeetCode449();
        String string = leetCode449.serialize(root);
        System.out.println(string);

        TreeNode treeNode = leetCode449.deserialize(string);

        System.out.println();
    }

    int index = 0;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();

        preOrder(root, builder);

        return builder.toString();
    }

    private void preOrder(TreeNode root, StringBuilder builder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur == null) {
                builder.append("#,");
            } else {
                builder.append(cur.val).append(",");
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] strs = data.split(",");

        return doSerialize(strs);
    }

    private TreeNode doSerialize(String[] strings) {
        if ("#".equals(strings[index])) {
            index++;
            return null;
        } else {
            TreeNode treeNode = new TreeNode(0);
            treeNode.val = Integer.parseInt(strings[index++]);
            treeNode.left = doSerialize(strings);
            treeNode.right = doSerialize(strings);

            return treeNode;
        }
    }

}
