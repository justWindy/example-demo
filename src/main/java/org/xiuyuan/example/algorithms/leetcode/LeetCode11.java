package org.xiuyuan.example.algorithms.leetcode;

/**
 * 盛最多水的容器
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 17:22
 */
public class LeetCode11 {

    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(leetCode11.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;

        int result = Integer.MIN_VALUE;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);

            result = Math.max(area, result);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
