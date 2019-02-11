package org.xiuyuan.example.algorithms.leetcode;

/**
 * 丑数
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 17:41
 */
public class LeetCode263 {

    public static void main(String[] args) {
        LeetCode263 leetCode263 = new LeetCode263();

        System.out.println(leetCode263.isUgly(14));
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        int count = 0;
        while (num != 1) {
            count++;
            if (num % 2 == 0) {
                num /= 2;
                count--;
                continue;
            }

            if (num % 3 == 0) {
                num /= 3;
                count--;
                continue;
            }

            if (num % 5 == 0) {
                num /= 5;
                count--;
                continue;
            }

            if (count >= 1) {
                return false;
            }
        }

        return true;
    }

}
