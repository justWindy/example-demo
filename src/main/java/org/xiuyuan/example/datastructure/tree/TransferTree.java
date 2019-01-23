package org.xiuyuan.example.datastructure.tree;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-20
 * Time: 23:33
 */
public class TransferTree {

    public static void main(String[] args) {

    }

    public void preTraverse(BinaryNode root) {

        Stack<BinaryNode> stack = new Stack<>();

        BinaryNode currentNode;
        BinaryNode temp;
        currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                System.out.println(currentNode.value + " ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                temp = stack.pop();
                currentNode = temp.right;
            }
        }
    }

    public void inTraverse(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();

        BinaryNode currentNode, tmp;
        currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                tmp = stack.pop();
                System.out.println(tmp.value + " ");
                currentNode = tmp.right;
            }
        }
    }

    public void postTraverse(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();

        BinaryNode currentNode, tmp;
        currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (!stack.isEmpty()) {
                tmp = stack.peek();
                if (tmp.isFirst = false) {
                    currentNode = tmp.right;
                    tmp.isFirst = true;
                } else {
                    tmp = stack.pop();
                    System.out.println(tmp.value + " ");
                }
            }
        }
    }

}
