package org.xiuyuan.example.algorithms.leetcode;

/**
 * 接雨水
 * created by helanzhou
 * Date: 2019-02-10
 * Time: 16:56
 */
public class LeetCode42 {

    public static void main(String[] args) {

        LeetCode42 leetCode42 = new LeetCode42();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(leetCode42.trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int result = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r && height[l] <= height[l + 1]) {
            l++;
        }

        while (l < r && height[r] <= height[r - 1]) {
            r--;
        }

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left < right) {
                while (l < r && left >= height[l]) {
                    result += left - height[l];
                    l++;
                }
            } else {
                while (l < r && right >= height[r]) {
                    result += right - height[r];
                    r--;
                }
            }
        }

        return result;
    }

}
