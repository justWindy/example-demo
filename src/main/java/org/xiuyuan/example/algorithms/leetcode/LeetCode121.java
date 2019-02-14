package org.xiuyuan.example.algorithms.leetcode;

/**
 * 买卖股票的最佳时机
 * created by helanzhou
 * Date: 2019-02-12
 * Time: 22:29
 */
public class LeetCode121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        LeetCode121 leetCode121 = new LeetCode121();
        System.out.println(leetCode121.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) {
            return 0;
        }

        int max = 0;
        int min = prices[0];
        for (int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
