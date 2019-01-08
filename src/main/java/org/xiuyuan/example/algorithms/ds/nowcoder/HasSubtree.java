package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 20:52
 */
public class HasSubtree {

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(8);
        TreeNode left1 = new TreeNode(8);
        TreeNode right1 = new TreeNode(7);
        TreeNode left11 = new TreeNode(9);
        TreeNode left12 = new TreeNode(2);
        TreeNode left121 = new TreeNode(4);
        TreeNode left122 = new TreeNode(7);

        tree1.left = left1;
        tree1.right = right1;
        left1.left = left11;
        left1.right = left12;
        left12.left = left121;
        left12.right = left122;

        TreeNode tree2 = new TreeNode(8);
        TreeNode left2 = new TreeNode(9);
        TreeNode right2 = new TreeNode(2);
        tree2.left = left2;
        tree2.right = right2;

        System.out.println(new HasSubtree().hasSubtree(tree1, tree2));
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }

        if (root2 == null) {
            return false;
        }

        boolean result = false;

        if (root1.val == root2.val) {
            result = doHasSubTree(root1, root2);
        }

        if (!result) {
            result = hasSubtree(root1.left, root2);
        }

        if (!result) {
            result = hasSubtree(root1.right, root2);
        }

        return result;

    }

    public boolean doHasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }


        if (root1.val != root2.val) {
            return false;
        }

        return doHasSubTree(root1.left, root2.left) && doHasSubTree(root1.right, root2.right);
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
