package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 17:55
 */
public class LeetCode60 {

    public static void main(String[] args) {

        LeetCode60 leetCode60 = new LeetCode60();

        System.out.println(leetCode60.getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }

        if (k > count(n) || k == 0) {
            return "";
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<String> list = new ArrayList<>();
        permutation(nums, 0, n - 1, list);
        Collections.sort(list);

        return list.get(k - 1);
    }

    private int count(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        return sum;
    }

    private void permutation(int[] nums, int from, int to, List<String> list) {
        if (from == to) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                builder.append(nums[i]);
            }

            list.add(builder.toString());
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums, i, from);
                permutation(nums, from + 1, to, list);
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
