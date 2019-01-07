package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 21:44
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 7, 8, 1, 2 };

        int[] array1 = { 1, 0, 1, 1, 1, 1, 1 };

        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();

        int value = minNumberInRotateArray.minNumberInRotateArray(array1);
        System.out.println("value=" + value);
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int length = array.length - 1;
        int start = 0, end = length;

        int result = 0;

        while (array[start] >= array[end]) {

            int mid = (start + end) / 2;
            if (end - start == 1) {
                result = array[end];
                break;
            }

            if (array[mid] == array[start] && array[mid] == array[end]) {
                return min(array);
            }

            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
        }

        return result;
    }

    public int min(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

}
