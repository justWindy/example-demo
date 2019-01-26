package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 22:33
 */
public class LeetCode429 {

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

        LeetCode429 leetCode429 = new LeetCode429();

        System.out.println(leetCode429.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        ArrayDeque<Node> first = new ArrayDeque<>();
        ArrayDeque<Node> second = new ArrayDeque<>();

        first.addLast(root);

        while (!first.isEmpty() || !second.isEmpty()) {

            List<Integer> list1 = new ArrayList<>();
            while (!first.isEmpty()) {
                Node current = first.pollFirst();
                list1.add(current.val);
                List<Node> nodes = current.children;
                if (nodes != null) {
                    for (Node node : nodes) {
                        second.addLast(node);
                    }
                }
            }
            if (!list1.isEmpty()) {
                lists.add(list1);
            }

            List<Integer> list2 = new ArrayList<>();
            while (!second.isEmpty()) {
                Node current = second.pollFirst();
                list2.add(current.val);
                List<Node> nodes = current.children;
                if (nodes != null) {
                    for (Node node : nodes) {
                        first.addLast(node);
                    }
                }
            }

            if (!list2.isEmpty()) {
                lists.add(list2);
            }
        }

        return lists;
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
