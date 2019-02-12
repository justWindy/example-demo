package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 19:56
 */
public class LeetCode236 {

    public static void main(String[] args) {
        LeetCode236 leetCode236 = new LeetCode236();

        TreeNode root = new TreeNode(3);
        TreeNode root0 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root00 = new TreeNode(6);
        TreeNode root01 = new TreeNode(2);
        TreeNode root10 = new TreeNode(0);
        TreeNode root11 = new TreeNode(8);
        TreeNode root010 = new TreeNode(7);
        TreeNode root011 = new TreeNode(4);

        root.left = root0;
        root.right = root1;
        root0.left= root00;
        root0.right = root01;
        root1.left = root10;
        root1.right = root11;
        root01.left = root010;
        root01.right = root011;

        TreeNode treeNode = leetCode236.lowestCommonAncestor(root, root0, root011);
        System.out.println();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        boolean flag1 = false;
        boolean flag2 = false;

        flag1 = getNodePath(root, p, path1);
        flag2 = getNodePath(root, q, path2);

        if (!flag1 || !flag2) {
            return null;
        }
        return findCommonNode(path1, path2);
    }

    private boolean getNodePath(TreeNode root, TreeNode pNode, List<TreeNode> list) {
        if (root == null) {
            return false;
        }

        list.add(root);
        if (root == pNode) {
            return true;
        }
        boolean found = getNodePath(root.left, pNode, list);
        if (!found) {
            found = getNodePath(root.right, pNode, list);
        }
        if (!found) {
            list.remove(list.size() - 1);
        }

        return found;
    }

    private TreeNode findCommonNode(List<TreeNode> path1, List<TreeNode> path2) {
        TreeNode treeNode = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                treeNode = path1.get(i);
            }
        }

        return treeNode;
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
