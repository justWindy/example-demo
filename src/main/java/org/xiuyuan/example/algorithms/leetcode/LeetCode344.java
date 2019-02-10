package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * 反转字符串
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 21:10
 */
public class LeetCode344 {

    public static void main(String[] args) {
        LeetCode344 leetCode344 = new LeetCode344();

        String s = "hello";
        char[] test = s.toCharArray();

        System.out.println(Arrays.toString(test));
        leetCode344.reverseString(test);
        System.out.println(Arrays.toString(test));

    }

    public void reverseString(char[] s) {
        if (s == null && s.length == 0) {
            return;
        }

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

}
