package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 丑数
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 10:34
 */
public class GetUglyNumber {

    public static void main(String[] args) {
        int value = new GetUglyNumber().GetUglyNumber_Solution(150);

        System.out.println(value);
    }

    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int nextIndex = 1;

        int[] uglyMultiply2 = uglyArray;
        int[] uglyMultiply3 = uglyArray;
        int[] uglyMultiply5 = uglyArray;

        int i, j, k;
        i = j = k = 0;
        while (nextIndex < index) {
            int min = min(uglyMultiply2[i] * 2, uglyMultiply3[j] * 3, uglyMultiply5[k] * 5);
            uglyArray[nextIndex] = min;

            while (uglyMultiply2[i] * 2 <= uglyArray[nextIndex]) {
                i++;
            }

            while (uglyMultiply3[j] * 3 <= uglyArray[nextIndex]) {
                j++;
            }

            while (uglyMultiply5[k] * 5 <= uglyArray[nextIndex]) {
                k++;
            }

            ++nextIndex;
        }

        int ugly = uglyArray[index - 1];
        return ugly;
    }

    private int min(int num1, int num2, int num3) {
        int min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;

        return min;
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1;
    }

    private int getUglyNumber(int index) {

        if (index <= 0) {
            return 0;
        }

        int number = 0;
        int uglyFound = 0;

        while (uglyFound < index) {
            ++number;
            if (isUgly(number)) {
                ++uglyFound;
            }

        }

        return number;
    }

}
