package org.xiuyuan.example.algorithms.leetcode;

/**
 * 最大子序和
 * created by helanzhou
 * Date: 2019-02-14
 * Time: 12:29
 */
public class LeetCode53 {

    public static void main(String[] args) {

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] nums1 = { -2, 1 };

        LeetCode53 leetCode53 = new LeetCode53();

        System.out.println(leetCode53.maxSubArray(nums));

        System.out.println(leetCode53.maxSubSequenceSum(nums, 0, nums.length - 1));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    private int maxSubSequenceSum(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSequenceSum(a, left, center);
        int maxRightSum = maxSubSequenceSum(a, center + 1, right);

        int leftBorderSum = 0, maxLeftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int rightBorderSum = 0, maxRightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = rightBorderSum;
            }
        }

        return Math.max(maxLeftSum, Math.max(maxRightSum, maxLeftBorderSum + maxRightBorderSum));
    }

}
