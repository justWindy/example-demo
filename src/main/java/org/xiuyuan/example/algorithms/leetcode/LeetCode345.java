package org.xiuyuan.example.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转字符串中的原因字母
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 18:13
 */
public class LeetCode345 {

    public static void main(String[] args) {
        LeetCode345 leetCode345 = new LeetCode345();

        System.out.println(leetCode345.reverseVowels("hello"));
        System.out.println(leetCode345.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        Set<Character> set = getSet();
        while (i < j) {
            if (!set.contains(chars[i])) {
                i++;
                continue;
            }

            if (!set.contains(chars[j])) {
                j--;
                continue;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }

    private Set<Character> getSet() {
        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        return set;
    }

}
