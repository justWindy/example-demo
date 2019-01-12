package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.HashMap;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 16:04
 */
public class DuplicateClass {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];

        System.out.println(duplicate(numbers, numbers.length, duplication));

    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || length == 0 || length == 1 || duplication == null || duplication.length == 0) {
            return false;
        }

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplication[0] = entry.getKey();
                return true;
            }
        }

        return false;
    }

}
