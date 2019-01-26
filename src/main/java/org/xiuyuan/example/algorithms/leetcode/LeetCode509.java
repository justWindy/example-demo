package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 16:48
 */
public class LeetCode509 {

    public static void main(String[] args) {

        LeetCode509 leetCode509 = new LeetCode509();

        System.out.println(leetCode509.fib(2));
    }

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        int[] array = new int[N + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[N];
    }

}
