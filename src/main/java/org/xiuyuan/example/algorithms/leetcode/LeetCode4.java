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

    public double recursiveFindMedian(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin < iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - 1;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

}
