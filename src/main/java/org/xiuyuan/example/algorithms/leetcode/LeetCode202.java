package org.xiuyuan.example.algorithms.leetcode;

/**
 * 快乐数
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 17:25
 */
public class LeetCode202 {

    public static void main(String[] args) {
        LeetCode202 leetCode202 = new LeetCode202();

        System.out.println(leetCode202.isHappy(2));
    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }

        int sum = n;

        while (sum != 1) {
            String str = String.valueOf(sum);
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                int value = str.charAt(i) - '0';
                sum += value * value;
            }

            if (sum == 4) {
                return false;
            }
        }

        return true;
    }

}
