package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 16:42
 */
public class LeetCode70 {

    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();

        System.out.println(leetCode70.climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[0] = array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }

}
