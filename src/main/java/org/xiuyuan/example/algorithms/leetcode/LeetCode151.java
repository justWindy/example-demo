package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 15:50
 */
public class LeetCode151 {

    public static void main(String[] args) {
        String str = " 1";

        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords(str));
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

}
