package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 23:03
 */
public class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);

        if (stack2.isEmpty() || top() < node) {
            stack2.push(node);
        } else {
            stack2.push(top());
        }

    }

    public void pop() {
        if (!stack1.empty() && !stack2.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        return stack2.peek();
    }

    public int min() {
        return top();
    }

}
