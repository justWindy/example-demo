package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 13:51
 */
public class IsContinuousClass {

    public static void main(String[] args) {

        int[] numbers = {1, 6, 0, 0, 5};

        System.out.println(new IsContinuousClass().isContinuous(numbers));

    }

    public boolean isContinuous(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }
        qsort(numbers, 0, numbers.length - 1);

        int numberOfZero = 0;
        int numberOfGap = 0;

        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }

        int small = numberOfZero;
        int big = small + 1;

        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }

            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }

        return numberOfGap <= numberOfZero;
    }

    private void qsort(int[] numbers, int low, int high) {
        if (high < low) {
            return;
        }
        int index = partition(numbers, low, high);
        qsort(numbers, low, index - 1);
        qsort(numbers, index + 1, high);
    }

    private int partition(int[] numbers, int low, int high) {
        if (low >= high) {
            return low;
        }

        int i = low, j = high + 1;
        int value = numbers[low];

        while (true) {
            while (numbers[++i] < value) {
                if (i == high) {
                    break;
                }
            }

            while (numbers[--j] > value) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(numbers, i, j);
        }
        swap(numbers, low, j);
        return j;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
