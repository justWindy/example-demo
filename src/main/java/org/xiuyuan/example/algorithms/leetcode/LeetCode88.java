package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 18:22
 */
public class LeetCode88 {

    public static void main(String[] args) {

        int[] nums1 = { 4, 5, 6, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3 };

        LeetCode88 leetCode88 = new LeetCode88();

        leetCode88.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            return;
        }

        if (nums2 == null) {
            return;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {

            for (int j = index; j <= m + i; j++) {
                if (nums2[i] < nums1[j]) {
                    moveArray(nums1, m + i, j);
                    nums1[j] = nums2[i];
                    break;
                } else {
                    index++;
                    if (j == m + i) {
                        nums1[j] = nums2[i];
                    }
                }
            }
        }
    }

    private void moveArray(int[] num, int index, int start) {
        for (int i = index; i > start; i--) {
            num[i] = num[i - 1];
        }
    }

}
