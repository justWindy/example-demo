package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-18
 * Time: 15:38
 */
public class MaxInWindowsClass {

    public static void main(String[] args) {
        int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };

        System.out.println(new MaxInWindowsClass().maxInWindows(num, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        if (num == null || size == 0) {
            return list;
        }

        int index = 0;
        while (index <= num.length - size) {
            list.add(getMaxValue(num, index, size));
            index++;
        }

        return list;
    }

    private int getMaxValue(int[] num, int index, int size) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = index; i < index + size; i++) {
            if (num[i] > maxValue) {
                maxValue = num[i];
            }
        }

        return maxValue;
    }

}
