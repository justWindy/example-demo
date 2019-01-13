package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-13
 * Time: 11:38
 */
public class IsSymmetricalClass {

    public static void main(String[] args) {

    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode pLeft, TreeNode pRight) {
        if (pLeft == null && pRight == null) {
            return true;
        }

        if (pLeft == null || pRight == null) {
            return false;
        }

        if (pLeft.val != pRight.val) {
            return false;
        }

        return isSymmetrical(pLeft.left, pRight.right) && isSymmetrical(pLeft.right, pRight.left);
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
