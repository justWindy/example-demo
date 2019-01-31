package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 11:28
 */
public class LeetCode31 {

    public static void main(String[] args) {
        LeetCode31 leetCode31 = new LeetCode31();

        int[] nums = {2, 3, 6, 5, 4, 1};
        leetCode31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index >= 0) {
            int j = index + 1;
            while (j < nums.length && nums[j] > nums[index]) {
                j++;
            }
            j--;
            swap(nums, index, j);
        }

        int low = index + 1;
        int high = nums.length - 1;
        while (low < high) {
            swap(nums, low++, high--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
