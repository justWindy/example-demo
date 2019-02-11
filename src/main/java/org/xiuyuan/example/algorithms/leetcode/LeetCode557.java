package org.xiuyuan.example.algorithms.leetcode;

/**
 * 反转字符串中的单词 III
 *
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 14:51
 */
public class LeetCode557 {

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";

        LeetCode557 leetCode557 = new LeetCode557();

        System.out.println(leetCode557.reverseWords(str));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String str : strings) {
            int start = 0;
            int end = str.length() - 1;
            char[] chars = str.toCharArray();
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            builder.append(chars).append(" ");
        }

        return builder.toString().trim();
    }

}
