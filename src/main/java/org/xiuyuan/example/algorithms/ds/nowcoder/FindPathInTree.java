package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-09
 * Time: 20:23
 */
public class FindPathInTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(12);
        TreeNode left11 = new TreeNode(4);
        TreeNode left12 = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = left11;
        left.right = left12;

        new FindPathInTree().FindPath(root, 22);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

        if (root == null) {
            return listAll;
        }

        Stack<Integer> stack = new Stack<>();
        FindPath(root, target, stack, listAll);

        return listAll;

    }

    private void FindPath(TreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> listAll) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i : stack) {
                    arrayList.add(i);
                }
                arrayList.add(root.val);
                listAll.add(arrayList);
            }
        } else {
            stack.push(root.val);
            FindPath(root.left, target - root.val, stack, listAll);
            FindPath(root.right, target - root.val, stack, listAll);
            stack.pop();
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

}
