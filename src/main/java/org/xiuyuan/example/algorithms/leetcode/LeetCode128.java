package org.xiuyuan.example.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 21:00
 */
public class LeetCode128 {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };

        LeetCode128 leetCode128 = new LeetCode128();

        System.out.println(leetCode128.longestConsecutive1(nums));
    }

    public int longestConsecutive(int[] nums) {

        int res = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (set.remove(pre)) {
                    pre--;
                }
                while (set.remove(next)) {
                    next++;
                }
                res = Math.max(res, next - pre - 1);
            }
        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }

            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;

            int sum = left + right + 1;
            map.put(num, sum);
            res = Math.max(res, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }

        return res;
    }

}
