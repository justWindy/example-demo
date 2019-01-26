package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 15:50
 */
public class LeetCode151 {

    public static void main(String[] args) {
        String str = "the sky is blue";

        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords(str));
        System.out.println(leetCode151.reverseWordsAnother(str));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] strs = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i].trim());
            if (i != 0) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public String reverseWordsAnother(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            Character ch = stack.pop();
            if (ch != ' ') {
                temp.append(ch);
            } else {
                if (temp.length() != 0) {
                    builder.append(temp.reverse()).append(' ');
                    temp.delete(0, temp.length());
                }
            }
        }

        if (temp.length() != 0) {
            builder.append(temp.reverse());
        }

        return builder.toString().trim();
    }

}
