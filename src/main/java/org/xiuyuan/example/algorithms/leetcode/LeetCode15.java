package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-27
 * Time: 21:24
 */
public class LeetCode15 {

    public static void main(String[] args) {

        int[] nums = { -2, 0, 1, 1, 2 };

        LeetCode15 leetCode15 = new LeetCode15();

        System.out.println(leetCode15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        sort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                ArrayList<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    if (!lists.contains(list)) {
                        lists.add(list);
                    }
                }

                if (sum <= 0) {
                    low++;
                } else {
                    high--;
                }
            }

        }

        return lists;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(nums, low, high);
        sort(nums, low, mid - 1);
        sort(nums, mid + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int i = low, j = high + 1;
        int value = nums[low];
        while (true) {
            while (nums[++i] < value && i < high) {
            }

            while (nums[--j] > value && j > low) {
            }

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
