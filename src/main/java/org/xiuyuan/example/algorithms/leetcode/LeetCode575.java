package org.xiuyuan.example.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 16:11
 */
public class LeetCode575 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};


        LeetCode575 leetCode575 = new LeetCode575();
        System.out.println(leetCode575.distributeCandies(nums));
    }

    /**
     * 1. 糖果种类数 <= 糖果总数 / 2，每种糖一个还差糖，只有同种糖多凑几个，糖果种类数即分得的最大种类数
     * 2. 糖果种类数 > 糖果总数 / 2，每种糖一个糖果都不够，只有少几个种类的糖，总数 / 2即分得的最大种类数
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();

        for (int value : candies) {
            set.add(value);
        }

        return set.size() <= candies.length / 2 ? set.size() : candies.length / 2;

    }

}
