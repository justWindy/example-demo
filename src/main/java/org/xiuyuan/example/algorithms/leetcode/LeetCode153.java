package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 22:25
 */
public class LeetCode153 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int[] nums1 = { 4 };
        int[] nums2 = { 3, 4, 5, 1, 2 };

        LeetCode153 leetCode153 = new LeetCode153();

        System.out.println(leetCode153.findMin(nums2));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int low = 0, high = nums.length - 1;

        while (nums[low] >= nums[high]) {
            int mid = (low + high) / 2;

            if (high - low == 1) {
                result = nums[high];
                break;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                result = nums[mid];
                break;
            }

            if (nums[low] < nums[mid]) {
                low = mid;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }
        }

        if (low == 0 && high == nums.length - 1 && nums[low] < nums[high]) {
            result = nums[low];
        }

        return result;
    }

}
