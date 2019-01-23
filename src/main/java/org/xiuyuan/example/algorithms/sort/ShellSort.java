package org.xiuyuan.example.algorithms.sort;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-21
 * Time: 12:05
 */
public class ShellSort {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;

        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 9, 6, 2, 4, 8, 7, 5, 3 };

        System.out.println("before sort:" + Arrays.toString(array));
        sort(array);
        System.out.println("after sort:" + Arrays.toString(array));
    }

}
