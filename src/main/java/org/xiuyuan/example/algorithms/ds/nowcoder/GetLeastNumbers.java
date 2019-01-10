package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 20:52
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
        List<Integer> list = new GetLeastNumbers().GetLeastNumbers_Solution(array, 8);

        System.out.println(list);
    }

    private static int partition(int[] array, int low, int high) {

        if (low == high) {
            return low;
        }

        int i = low, j = high + 1;

        int value = array[low];
        while (true) {
            while (array[++i] < value) {
                if (i == high) {
                    break;
                }
            }
            while (value < array[--j]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length || input.length == 0 || k == 0) {
            return list;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {

            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }
}
