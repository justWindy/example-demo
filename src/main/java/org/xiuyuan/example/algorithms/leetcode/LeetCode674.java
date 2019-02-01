package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 10:13
 */
public class LeetCode674 {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 7 };

        LeetCode674 leetCode674 = new LeetCode674();
        System.out.println(leetCode674.findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 1;

        int max = 0;
        while (end < nums.length) {
            if (nums[end] > nums[end - 1]) {
                end++;
            } else {
                int length = end - start;
                if (max < length) {
                    max = length;
                }
                start = end++;
            }
        }

        int value = end - start;
        if (max < value) {
            max = value;
        }

        return max;
    }

}
