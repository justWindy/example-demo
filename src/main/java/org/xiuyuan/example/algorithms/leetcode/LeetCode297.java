package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 10:26
 */
public class LeetCode297 {

    int index = 0;

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

        LeetCode297 leetCode297 = new LeetCode297();
        String string = leetCode297.serialize(root);
        System.out.println(string);

        TreeNode treeNode = leetCode297.deserialize(string);

        System.out.println();
    }

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();

        preOrder(root, builder);

        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        return doDeserialize(data.split(","));
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

    private TreeNode doDeserialize(String[] strs) {
        if ("#".equals(strs[index])) {
            index++;
            return null;
        } else {
            TreeNode node = new TreeNode(0);
            node.val = Integer.parseInt(strs[index++]);
            node.left = doDeserialize(strs);
            node.right = doDeserialize(strs);
            return node;
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
