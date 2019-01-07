package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 22:02
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("value: " + fibonacci(40));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int[] array = new int[40];
        array[0] = 0;
        array[1] = array[2] = 1;

        for (int i = 3; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }

        if (n >= 39) {
            return array[39];
        }

        return array[n];
    }

}
