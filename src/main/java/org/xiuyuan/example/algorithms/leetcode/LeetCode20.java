package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 11:26
 */
public class LeetCode20 {

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println(leetCode20.isValid(s5));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char value = stack.pop();
                if (current == ')') {
                    if (value != '(') {
                        return false;
                    }
                } else if (current == ']') {
                    if (value != '[') {
                        return false;
                    }
                } else {
                    if (value != '{') {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

}
