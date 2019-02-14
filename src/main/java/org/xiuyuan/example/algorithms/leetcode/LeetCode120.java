package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * created by helanzhou
 * Date: 2019-02-14
 * Time: 17:23
 */
public class LeetCode120 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));

        LeetCode120 leetCode120 = new LeetCode120();
        System.out.println(leetCode120.minimumTotal(lists));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
            }
        }

        return res[0];
    }

}
