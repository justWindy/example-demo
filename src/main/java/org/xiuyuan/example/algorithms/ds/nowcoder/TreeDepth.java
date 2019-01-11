package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 16:18
 */
public class TreeDepth {

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

        int reuslt = new TreeDepth().TreeDepth(root);

        System.out.println(reuslt);
    }


    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

}
