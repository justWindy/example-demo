package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 12:48
 */
public class LeetCode438 {

    public static void main(String[] args) {

        LeetCode438 leetCode438 = new LeetCode438();

        System.out.println(leetCode438.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return list;
        }

        if (p.length() > s.length()) {
            return list;
        }

        int length = p.length();
        String sortedP = sortedKey(p);
        for (int i = 0; i < s.length(); ) {
            if (length + i <= s.length()) {
                String str = sortedKey(s.substring(i, length + i));

                if (sortedP.equals(str)) {
                    list.add(i);
                    i++;
                } else {
                    i += length;
                }

            } else {
                i++;
            }
        }

        return list;
    }

    private String sortedKey(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return String.valueOf(chars);
    }

}
