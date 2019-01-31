package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 17:32
 */
public class LeetCode889 {

    public static void main(String[] args) {

        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] post = { 4, 5, 2, 6, 7, 3, 1 };

        int[] pre1 = { 2, 1, 3 };
        int[] post1 = { 3, 1, 2 };

        LeetCode889 leetCode889 = new LeetCode889();

        TreeNode treeNode = leetCode889.constructFromPrePost(pre, post);

        System.out.println();

    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length || pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        if (pre.length > 1) {

            int rightChild = post[post.length - 2];

            int leftIndex = 0;
            for (int i = 1; i < pre.length; i++) {
                if (pre[i] == rightChild) {
                    leftIndex = i;
                    break;
                }
            }

            int[] leftPre = new int[leftIndex - 1];
            int[] leftPost = new int[leftIndex - 1];
            int[] rightPre = new int[pre.length - leftIndex];
            int[] rightPost = new int[pre.length - leftIndex];

            System.arraycopy(pre, 1, leftPre, 0, leftIndex - 1);
            System.arraycopy(post, 0, leftPost, 0, leftIndex - 1);
            System.arraycopy(pre, leftIndex, rightPre, 0, pre.length - leftIndex);
            System.arraycopy(post, leftIndex - 1, rightPost, 0, pre.length - leftIndex);

            root.left = constructFromPrePost(leftPre, leftPost);
            root.right = constructFromPrePost(rightPre, rightPost);
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
