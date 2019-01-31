package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-30
 * Time: 21:07
 */
public class LeetCode46 {

    public static void main(String[] args) {

        LeetCode46 leetCode46 = new LeetCode46();

        int[] nums = {1, 2, 3};
        System.out.println(leetCode46.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        permution(nums, 0, nums.length - 1, lists);
        return lists;
    }

    private void permution(int[] nums, int from, int to, List<List<Integer>> lists) {
        if (from == to) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            lists.add(list);
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums, i, from);
                permution(nums, from + 1, to, lists);
                swap(nums, from, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
