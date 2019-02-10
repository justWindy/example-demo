package org.xiuyuan.example.algorithms.leetcode;

/**
 * 反转字符串 II
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 21:20
 */
public class LeetCode541 {

    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }

        int len = s.length();
        char[] chars = s.toCharArray();
        int index = 0;

        while (index < len) {
            if (len - index > k) {
                for (int i = index, j = index + k - 1; i < j; i++, j--) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                index += 2 * k;
            } else {
                for (int i = index, j = len - 1; i < j; i++, j--) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                index = len;
            }
        }

        return new String(chars);
    }

}
