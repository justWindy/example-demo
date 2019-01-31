package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-30
 * Time: 21:25
 */
public class LeetCode44 {

    public static void main(String[] args) {

        LeetCode44 leetCode44 = new LeetCode44();

//        System.out.println(leetCode44.isMatch("mississippi", "m??*ss*?i*pi"));
        System.out.println(leetCode44.isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (dp[0][j] && p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }

        }

        return dp[s.length()][p.length()];
    }

    private boolean dpMethod(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean isFirstMatch =
                !(s.isEmpty()) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*');

        if (p.charAt(0) == '*') {
            boolean first = isMatch(s, p.substring(1));
            boolean second = isFirstMatch && isMatch(s.substring(1), p);

            return first || second;
        } else {
            return isFirstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


}
