package org.xiuyuan.example.algorithms.leetcode;

import java.util.List;

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

    private static boolean checkIfTheSame(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() == 0) {
            return false;
        }

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (checkIfTheSame(count1, count2)) {
                return true;
            }

            count2[s2.charAt(i - s1.length()) - 'a']--;
            count2[s2.charAt(i) - 'a']++;
        }

        return checkIfTheSame(count1, count2);
    }

}
