package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 17:54
 */
public class FindNumbersWithSumClass {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 7, 11, 12, 15 };

        System.out.println(new FindNumbersWithSumClass().FindNumbersWithSum(array, 15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex < lastIndex) {
            int current = array[firstIndex] + array[lastIndex];
            if (current == sum) {
                listAll.add(addSequence(array, firstIndex, lastIndex));
                firstIndex++;
            } else if (current > sum) {
                lastIndex--;
            } else {
                firstIndex++;
            }
        }

        if (listAll.isEmpty()) {
            return new ArrayList<>();
        }

        return listAll.get(0);
    }

    public ArrayList<Integer> addSequence(int[] array, int firstIndex, int lastIndex) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(array[firstIndex]);
        list.add(array[lastIndex]);

        return list;
    }

}
