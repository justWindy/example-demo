package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 22:49
 */
public class LeetCode119 {

    public static void main(String[] args) {
        long sum = 1;

        for (int i = 33, j = 1; i > 0 && j <= 16; i--, j++) {
            sum *= i;
            sum /= j;

            System.out.print(((int) sum) + " ");
        }

        LeetCode119 leetCode119 = new LeetCode119();

        System.out.println(leetCode119.getRow(33));

    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }

        Integer[] array = new Integer[rowIndex + 1];

        int length = array.length;

        array[0] = 1;
        if ((length & 1) == 0) {

            for (int i = 1; i < length / 2; i++) {
                array[i] = group(array[i - 1], i, rowIndex);
            }

            for (int j = length / 2; j < length; j++) {
                array[j] = array[length - j - 1];
            }

        } else {
            for (int i = 1; i < length / 2 + 1; i++) {
                array[i] = group(array[i - 1], i, rowIndex);
            }

            for (int j = length / 2 + 1; j < length; j++) {
                array[j] = array[length - j - 1];
            }
        }

        return Arrays.asList(array);
    }

    private int group(int init, int i, int row) {
        long value = init;

        value = value  * (row - i + 1) / i;

        return (int) value;
    }

}
