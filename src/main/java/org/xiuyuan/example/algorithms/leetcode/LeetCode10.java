package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-30
 * Time: 20:45
 */
public class LeetCode10 {

    public static void main(String[] args) {

        LeetCode10 leetCode10 = new LeetCode10();

        System.out.println(leetCode10.isMatch("aa", ""));

    }

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean first = isMatch(s, p.substring(2));
            boolean second = firstMatch && isMatch(s.substring(1), p);
            return first || second;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
