package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 11:38
 */
public class LeetCode4 {

    public static void main(String[] args) {

        int[] num1 = { 1, 2 };
        int[] num2 = { 3, 4 };

        LeetCode4 leetCode4 = new LeetCode4();

        System.out.println(leetCode4.findMedianSortedArrays(num1, num2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }

        if (nums1 == null) {
            return findMedian(nums2);
        } else if (nums2 == null) {
            return findMedian(nums1);
        } else {
            int length1 = nums1.length;
            int length2 = nums2.length;

            int[] nums = new int[length1 + length2];
            int j = 0, k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j >= length1) {
                    nums[i] = nums2[k++];
                } else if (k >= length2) {
                    nums[i] = nums1[j++];
                } else if (nums1[j] < nums2[k]) {
                    nums[i] = nums1[j++];
                } else {
                    nums[i] = nums2[k++];
                }
            }

            return findMedian(nums);
        }

    }

    private double findMedian(int[] num) {
        int length = num.length;

        if ((length & 1) != 0) {
            return num[length / 2];
        } else {
            return (num[length / 2] + num[length / 2 - 1]) / 2.0;
        }
    }

}
