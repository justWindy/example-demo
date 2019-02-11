package org.xiuyuan.example.algorithms.leetcode;

/**
 * 丑数 II
 * <p>
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 17:51
 */
public class LeetCode264 {

    public static void main(String[] args) {
        LeetCode264 leetCode264 = new LeetCode264();

        System.out.println(leetCode264.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int nextIndex = 1;

        int[] uglyMultiply2 = uglyArray;
        int[] uglyMultiply3 = uglyArray;
        int[] uglyMultiply5 = uglyArray;

        int i, j, k;
        i = j = k = 0;

        while (nextIndex < n) {
            int min = min(uglyMultiply2[i] * 2, uglyMultiply3[j] * 3, uglyMultiply5[k] * 5);
            uglyArray[nextIndex] = min;

            while (uglyMultiply2[i] * 2 <= uglyArray[nextIndex]) {
                i++;
            }

            while (uglyMultiply3[j] * 3 <= uglyArray[nextIndex]) {
                j++;
            }

            while (uglyMultiply5[k] * 5 <= uglyArray[nextIndex]) {
                k++;
            }
            ++nextIndex;
        }

        return uglyArray[n - 1];
    }

    private int min(int num1, int num2, int num3) {
        int min = (num1 < num2) ? num1 : num2;
        min = min < num3 ? min : num3;

        return min;
    }
}
