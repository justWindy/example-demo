package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 22:23
 */
public class LeetCode590 {

    public static void main(String[] args) {
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

        LeetCode590 leetCode590 = new LeetCode590();

        System.out.println(leetCode590.postorder(root));
    }

    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        recurtion(root, list);


        return list;

    }

    private void recurtion(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        List<Node> nodes = root.children;
        if (nodes != null) {
            for (Node node : nodes) {
                recurtion(node, list);
            }
        }
        list.add(root.val);
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
