package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 20:50
 */
public class LeetCode703 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(3, nums);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    public static class KthLargest {

        private List<Integer> list = new ArrayList<>();
        private int           k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
        }

        public int add(int val) {
            list.add(val);
            Collections.sort(list);

            return list.get(list.size() - k);
        }
    }

}
