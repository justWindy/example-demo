package org.xiuyuan.example.algorithms.leetcode;

/**
 * 买卖股票的最佳时机 II
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 22:55
 */
public class LeetCode122 {

    public static void main(String[] args) {

        LeetCode122 leetCode122 = new LeetCode122();

        int[] array = { 1, 2, 3, 4, 5 };
        int[] array1 = { 7, 1, 5, 3, 6, 4 };
        int[] array2 = { 7, 6, 5, 4, 3, 2, 1};

        System.out.println(leetCode122.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }

}
