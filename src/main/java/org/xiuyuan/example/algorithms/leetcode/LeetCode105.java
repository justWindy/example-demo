package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 20:39
 */
public class LeetCode105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        LeetCode105 leetCode105 = new LeetCode105();
        TreeNode treeNode = leetCode105.buildTree(preorder, inorder);

        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length != preorder.length || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        if (preorder.length > 1) {
            int rootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    rootIndex = i;
                    break;
                }
            }

            int[] leftPre = new int[rootIndex];
            int[] leftIn = new int[rootIndex];
            int[] rightPre = new int[inorder.length - rootIndex - 1];
            int[] rightIn = new int[inorder.length - rootIndex - 1];

            System.arraycopy(preorder, 1, leftPre, 0, rootIndex);
            System.arraycopy(inorder, 0, leftIn, 0, rootIndex);
            System.arraycopy(preorder, rootIndex + 1, rightPre, 0, inorder.length - rootIndex - 1);
            System.arraycopy(inorder, rootIndex + 1, rightIn, 0, inorder.length - rootIndex - 1);

            root.left = buildTree(leftPre, leftIn);
            root.right = buildTree(rightPre, rightIn);
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
