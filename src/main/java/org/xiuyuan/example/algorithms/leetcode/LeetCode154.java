package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 22:36
 */
public class LeetCode154 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };

        LeetCode154 leetCode154 = new LeetCode154();
        System.out.println(leetCode154.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        int result = 0;

        while (nums[start] >= nums[end]) {
            int mid = (start + end) / 2;
            if (end - start == 1) {
                result = nums[end];
                break;
            }

            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                result = min(nums);
                break;
            }

            if (nums[start] <= nums[mid]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }

        return result;
    }

    private int min(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        return min;
    }

}
