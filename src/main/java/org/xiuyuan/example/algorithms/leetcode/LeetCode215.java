package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 18:26
 */
public class LeetCode215 {

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();

        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int[] nums1 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };

        System.out.println(leetCode215.findKthLargest(nums1, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (k > length) {
            return 0;
        }

        heapSort(nums);

        return nums[length - k];

    }

    public void heapSort(int[] nums) {
        int length = nums.length;

        for (int i = length / 2; i >= 0; i--) {
            swim(nums, i, length);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i);
            swim(nums, 0, i);
        }
    }

    public int leftChild(int k) {
        return 2 * k + 1;
    }

    public int rightChild(int k) {
        return 2 * k + 2;
    }

    public void swim(int[] nums, int k, int n) {
        int left = leftChild(k);
        int right = rightChild(k);
        int maxValue = k;

        if (left < n && nums[maxValue] < nums[left]) {
            maxValue = left;
        }

        if (right < n && nums[maxValue] < nums[right]) {
            maxValue = right;
        }

        if (maxValue != k) {
            swap(nums, k, maxValue);
            swim(nums, maxValue, n);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
