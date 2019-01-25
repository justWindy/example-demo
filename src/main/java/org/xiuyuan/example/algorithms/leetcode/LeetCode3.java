package org.xiuyuan.example.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * created by helanzhou
 * Date: 2019-01-24
 * Time: 21:54
 */
public class LeetCode3 {

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbb";
        String str3 = "pwwkew";
        String str4 = "dvdf";
        String str5 = "au";

        LeetCode3 leetCode3 = new LeetCode3();

        System.out.println("maxLength=" + leetCode3.lengthOfLongestSubstring(str5));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int start = 0;
        int length = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {

            if (map.containsKey(chars[i])) {
                if (start <= map.get(chars[i])) {
                    start = map.get(chars[i]) + 1;
                }
            }

            if (i - start >= maxLength) {
                maxLength = i + 1 - start;
            }

            map.put(chars[i], i);
        }

        return maxLength;
    }

}
