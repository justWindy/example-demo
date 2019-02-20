package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 重建二叉树
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 20:26
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = reConstructBinaryTree(pre, in);

        System.out.println("end");

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null) {
            return null;
        }

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }

        int[] leftIn = new int[rootIndex];
        int[] rightIn = new int[in.length - rootIndex - 1];
        int[] leftPre = new int[rootIndex];
        int[] rightPre = new int[pre.length - rootIndex - 1];

        System.arraycopy(in, 0, leftIn, 0, rootIndex);
        System.arraycopy(in, rootIndex + 1, rightIn, 0, in.length - rootIndex - 1);
        System.arraycopy(pre,  1, leftPre, 0, rootIndex);
        System.arraycopy(pre, rootIndex + 1, rightPre, 0, pre.length - rootIndex -1);

        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);

        return root;
    }

    public static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
