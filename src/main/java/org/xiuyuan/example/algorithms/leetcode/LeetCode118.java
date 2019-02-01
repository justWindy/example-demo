package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 09:07
 */
public class LeetCode118 {

    public static void main(String[] args) {

        LeetCode118 leetCode118 = new LeetCode118();

        System.out.println(leetCode118.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();


        if (numRows == 0) {
            return lists;
        }

        lists.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            Integer[] array = new Integer[i + 1];

            int length = array.length;

            array[0] = 1;
            if ((length & 1) != 0) {

                for (int j = 1; j < length / 2 + 1; j++) {
                    array[j] = group(array[j - 1], j, i);
                }

                for (int j = length / 2 + 1; j < length; j++) {
                    array[j] = array[length - j - 1];
                }

            } else {
                for (int j = 1; j < length / 2; j++) {
                    array[j] = group(array[j - 1], j, i);
                }

                for (int j = length / 2; j < length; j++) {
                    array[j] = array[length - j - 1];
                }
            }

            lists.add(Arrays.asList(array));
        }

        return lists;

    }

    private int group(int init, int i, int row) {
        long value = init;

        value = value * (row - i + 1) / i;

        return (int) value;
    }

}
