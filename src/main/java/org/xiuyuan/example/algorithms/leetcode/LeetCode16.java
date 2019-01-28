package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-27
 * Time: 22:47
 */
public class LeetCode16 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        LeetCode16 leetCode16 = new LeetCode16();

        System.out.println(leetCode16.threeSumClosest(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (result == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum <= target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }

}
