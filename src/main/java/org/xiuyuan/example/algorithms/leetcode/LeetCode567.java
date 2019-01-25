package org.xiuyuan.example.algorithms.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by helanzhou
 * Date: 2019-01-24
 * Time: 22:56
 */
public class LeetCode567 {

    public static void main(String[] args) {

        LeetCode567 leetCode567 = new LeetCode567();

        System.out.println(leetCode567.checkInclusion("ab", "eidbaooo"));

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void permutation(char[] chars, int from, int to, List<String> list) {
        if (from == to) {
            list.add(new String(chars));
            return;
        } else {
            for (int i = from; i <= to; i++) {
                swap(chars, i, from);
                permutation(chars, from + 1, to, list);
                swap(chars, from, i);
            }
        }
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0) {
            return false;
        }

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }

        for (char ch : s2.toCharArray()) {
            if (map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) == null || entry.getValue().intValue() != map2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

}
