package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.HashMap;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 17:13
 */
public class FindNumsAppearOnceClass {

    public static void main(String[] args) {

        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        new FindNumsAppearOnceClass().FindNumsAppearOnce(array, num1, num2);

        System.out.println();
    }

    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }

        if (num1 == null || num1.length == 0) {
            return;
        }

        if (num2 == null || num2.length == 0) {
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 1 + map.get(array[i]));
            } else {
                map.put(array[i], 1);
            }
        }
        boolean flag = true;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (flag) {
                    num1[0] = entry.getKey();
                    flag = false;
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }
}
