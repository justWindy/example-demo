package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-25
 * Time: 20:52
 */
public class LeetCode43 {

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "9";

        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length();

        int[] newArray = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                newArray[len1 + len2 - 2 - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        String result = "";
        for (int i = 0; i < len1 + len2 - 1; i++) {
            newArray[i + 1] += newArray[i] / 10;
            newArray[i] %= 10;
            result = (char) (newArray[i] + '0') + result;
        }

        result = (0 == newArray[len1 + len2 - 1] ? "" : (char) (newArray[len1 + len2 - 1] + '0')) + result;

        return result;
    }

}
