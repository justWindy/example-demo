package org.xiuyuan.example.algorithms.leetcode;

import java.util.Stack;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 17:12
 */
public class LeetCode71 {

    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].isEmpty()) {
                continue;
            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(paths[i]);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, "/");
        }

        return builder.length() == 0 ? "/" : builder.toString();
    }

}
