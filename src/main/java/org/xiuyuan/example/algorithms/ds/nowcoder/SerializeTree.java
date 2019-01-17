package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-13
 * Time: 15:53
 */
public class SerializeTree {

    private int index = 0;

    public String Serialize(TreeNode root) {
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

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        TreeNode treeNode = doDeserialize(str.split(","));
        return treeNode;
    }

    private TreeNode doDeserialize(String[] strs) {
        if ("#".equals(strs[index])) {
            index++;
            return null;
        } else {
            TreeNode node = new TreeNode(0);
            node.val = Integer.parseInt(strs[index]);
            index++;
            node.left = doDeserialize(strs);
            node.right = doDeserialize(strs);
            return node;
        }
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

        SerializeTree serializeTree = new SerializeTree();
        String str = serializeTree.Serialize(root);
        System.out.println(str);
        System.out.println(serializeTree.Deserialize(str));
    }

}
