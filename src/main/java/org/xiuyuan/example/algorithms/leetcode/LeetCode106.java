package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 21:01
 */
public class LeetCode106 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        LeetCode106 leetCode106 = new LeetCode106();

        TreeNode treeNode = leetCode106.buildTree(inorder, postorder);
        System.out.println();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        int length = postorder.length;
        TreeNode root = new TreeNode(postorder[length - 1]);

        if (length > 1) {
            int rootIndex = 0;
            for (int i = 0; i < length; i++) {
                if (inorder[i] == postorder[length - 1]) {
                    rootIndex = i;
                    break;
                }
            }

            int[] leftin = new int[rootIndex];
            int[] leftpost = new int[rootIndex];
            int[] rightin = new int[length - rootIndex - 1];
            int[] rightpost = new int[length - rootIndex - 1];

            System.arraycopy(inorder, 0, leftin, 0, rootIndex);
            System.arraycopy(postorder, 0, leftpost, 0, rootIndex);
            System.arraycopy(inorder, rootIndex + 1, rightin, 0, length - rootIndex - 1);
            System.arraycopy(postorder, rootIndex, rightpost, 0, length - rootIndex - 1);

            root.left = buildTree(leftin, leftpost);
            root.right = buildTree(rightin, rightpost);
        }

        return root;
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
