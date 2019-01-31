package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 12:42
 */
public class LeetCode242 {

    public static void main(String[] args) {
        LeetCode242 leetCode242 = new LeetCode242();

        System.out.println(leetCode242.isAnagram("rat", "cat"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        String sortS = sortedKey(s);
        String sortT = sortedKey(t);

        return sortS.equals(sortT);
    }

    private String sortedKey(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return String.valueOf(chars);
    }

}
