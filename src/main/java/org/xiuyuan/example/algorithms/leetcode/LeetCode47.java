package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-30
 * Time: 21:15
 */
public class LeetCode47 {

    public static void main(String[] args) {

        LeetCode47 leetCode47 = new LeetCode47();

        int[] nums = { 1, 1, 2 };

        System.out.println(leetCode47.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return lists;
        }

        permute(nums, 0, nums.length - 1, lists);

        return lists;
    }

    private void permute(int[] nums, int from, int to, List<List<Integer>> lists) {
        if (from == to) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            if (!lists.contains(list)) {
                lists.add(list);
            }
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums, i, from);
                permute(nums, from + 1, to, lists);
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
