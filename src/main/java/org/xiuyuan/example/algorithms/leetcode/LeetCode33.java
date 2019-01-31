package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 21:32
 */
public class LeetCode33 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        int[] nums2 = { 3, 1 };
        LeetCode33 leetCode33 = new LeetCode33();

        System.out.println(leetCode33.search(nums2, 1));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;

        while (nums[low] >= nums[high]) {
            int mid = (low + high) / 2;
            if (high - low == 1) {
                break;
            }

            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                break;
            }

            if (nums[low] < nums[mid]) {
                low = mid;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            }
        }

        if (low == 0 && high == nums.length - 1 && nums[high] >= nums[low]) {
            return binarySearch(nums, target, low, high);
        }

        int search1 = binarySearch(nums, target, 0, low);
        if (search1 != -1) {
            return search1;
        } else {
            return binarySearch(nums, target, high, nums.length - 1);
        }

    }

    private int binarySearch(int[] array, int target, int start, int end) {
        int low = start, high = end;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
