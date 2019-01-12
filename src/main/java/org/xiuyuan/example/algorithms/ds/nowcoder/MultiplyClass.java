package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 16:20
 */
public class MultiplyClass {

    public static void main(String[] args) {

    }

    public static int[] multiply(int[] A) {
        if (A == null || A.length == 1) {
            return null;
        }

        int len = A.length;
        int[] array = new int[len];
        array[0] = 1;

        for (int i = 1; i < len; i++) {
            array[i] = array[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i=len - 2; i>=0; i--) {
            temp *= A[i+1];
            array[i] *= temp;
        }

        return array;
    }

}
