package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 20:44
 */
public class LeetCode589 {

    public static void main(String[] args) {
        LeetCode589 leetCode589 = new LeetCode589();

        Node root = new Node();
        root.val = 1;
        Node root1 = new Node();
        root1.val = 3;
        Node root2 = new Node();
        root2.val = 2;
        Node root3 = new Node();
        root3.val = 4;
        root.children = Arrays.asList(root1, root2, root3);
        Node root11 = new Node();
        root11.val = 5;
        Node root12 = new Node();
        root12.val = 6;
        root1.children = Arrays.asList(root11, root12);

        System.out.println(leetCode589.preorder(root));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        recursive(root, list);

        return list;
    }

    private void recursive(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        List<Node> nodes = root.children;
        if (nodes != null) {
            for (Node node : nodes) {
                recursive(node, list);
            }
        }
    }

    private void nonRecursive(Node root, List<Integer> list) {

        Node current = root;

        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                List<Node> children = current.children;
                if (children != null) {

                }
            }
        }

    }

    private static class Node {

        public int        val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
