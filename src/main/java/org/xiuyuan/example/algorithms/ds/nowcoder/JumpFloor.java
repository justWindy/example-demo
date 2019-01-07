package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 22:10
 */
public class JumpFloor {

    public static void main(String[] args) {
        int value = jumpFloorII(3);
        System.out.println(value);
    }

    public static int jumpFloor(int target) {
        if (target == 0) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        int[] array = new int[target + 1];
        array[0] = array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[target];
    }

    public static int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        int[] array = new int[target + 1];
        array[0] = array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                array[i] += array[j];
            }
        }

        return array[target];
    }

}
