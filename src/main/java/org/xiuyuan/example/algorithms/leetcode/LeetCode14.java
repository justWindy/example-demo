package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-24
 * Time: 22:21
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] strs1 = { "flower", "flow", "flight" };
        String[] strs2 = { "dog", "racecar", "car" };
        String[] strs3 = { "aac", "ab" };

        LeetCode14 leetCode14 = new LeetCode14();

        System.out.println("prefix = " + leetCode14.longestCommonPrefix(strs3));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int index = 0;
        int minLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                index = i;
            }
        }

        String prefix;
        boolean contains = true;
        for (int i = minLength; i >= 0; i--) {
            prefix = strs[index].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    contains = false;
                    break;
                }

                if (j == strs.length - 1) {
                    contains = true;
                }

            }

            if (contains) {
                return prefix;
            }
        }

        return "";
    }

}
