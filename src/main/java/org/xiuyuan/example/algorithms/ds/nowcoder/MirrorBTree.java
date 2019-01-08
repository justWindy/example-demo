package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 21:13
 */
public class MirrorBTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(10);

        TreeNode left11 = new TreeNode(5);
        TreeNode left12 = new TreeNode(7);

        TreeNode right11 = new TreeNode(9);
        TreeNode right12 = new TreeNode(11);

        root.left = left;
        root.right = right;

        left.left = left11;
        left.right = left12;

        right.left = right11;
        right.right = right12;

        new MirrorBTree().Mirror(root);

        System.out.println(root.val);
    }

    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
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
