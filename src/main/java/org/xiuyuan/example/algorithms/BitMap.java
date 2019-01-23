package org.xiuyuan.example.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-23
 * Time: 12:00
 */
public class BitMap {

    private static final int MAX_COUNT = 10000000;

    private int[] array = new int[MAX_COUNT / 32 + 1];

    public static void main(String[] args) {
        int num[] = { 1, 5, 30, 32, 64, 56, 159, 120, 21, 17, 35, 45 };

        BitMap map = new BitMap();
        for (int i = 0; i < num.length; i++) {
            map.addValue(num[i]);
        }

        int temp = 120;
        if (map.exist(temp)) {
            System.out.println("temp:" + temp + "has already exists");
        }
        map.display(5);
    }

    public void addValue(int n) {
        int row = n >> 5;
        array[row] |= 1 << (n & 0x1F);
    }

    public boolean exist(int n) {
        int row = n >> 5;
        return (array[row] & (1 << (n & 0x1F))) != 1;
    }

    public void display(int row) {
        System.out.println("BitMap位图展示");

        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = array[i];
            for (int j = 0; j < 32; j++) {
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a[" + i + "]" + list);
        }
    }
}
