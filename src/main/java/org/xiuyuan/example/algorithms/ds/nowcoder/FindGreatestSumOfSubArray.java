package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 连续子数组的最大和
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 21:23
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {

        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};

        int result = new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array);


        System.out.println(result);
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if (currentSum < 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }

            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }

        return greatestSum;
    }

}
