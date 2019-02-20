package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 21:00
 */
public class TwoStackAsQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {

    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();

    }

}
