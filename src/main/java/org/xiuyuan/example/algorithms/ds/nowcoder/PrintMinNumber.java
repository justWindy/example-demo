package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 22:46
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        String result = new PrintMinNumber().PrintMinNumber(array);

        System.out.println(result);
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        if (numbers.length == 0) {
            return "";
        }

        ArrayList<String> list = new ArrayList<>();
        permutation(numbers, 0, numbers.length - 1, list);
        Collections.sort(list);
        return list.get(0);
    }

    private void permutation(int[] array, int from, int to, ArrayList<String> list) {

        if (from == to) {
            StringBuilder builder = new StringBuilder();
            Arrays.stream(array).forEach(value -> builder.append(value));
            list.add(builder.toString());
        } else {
            for (int i = from; i <= to; i++) {
                swap(array, from, i);
                permutation(array, from + 1, to, list);
                swap(array, i, from);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
