package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 23:38
 */
public class ReorderArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ReorderArray reorderArray = new ReorderArray();
        reorderArray.reOrderAgain(array);

        System.out.println(Arrays.toString(array));
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int indexStart = 0;
        int indexEnd = array.length - 1;

        while (indexStart <= indexEnd) {
            if (!isEven(array[indexStart])) {
                indexStart++;
                continue;
            }

            if (isEven(array[indexEnd])) {
                indexEnd--;
            } else {
                int temp = array[indexEnd];
                array[indexEnd] = array[indexStart];
                array[indexStart] = temp;
            }
        }


    }

    public boolean isEven(int value) {
        return (value & 0x1) == 0;
    }

    public void reOrderAgain(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int indexStart = 0;
        int indexSecond = 0;

        while (indexStart < array.length) {
            if (!isEven(array[indexStart])) {
                indexStart++;
            } else {

                for (indexSecond = indexStart + 1; indexSecond <array.length; indexSecond++) {
                    if (!isEven(array[indexSecond])) {
                        int temp = array[indexStart];
                        array[indexStart] = array[indexSecond];
                        array[indexSecond] = temp;
                        break;
                    } else {
                        if (array[indexStart] > array[indexSecond]) {
                            int temp = array[indexStart];
                            array[indexStart] = array[indexSecond];
                            array[indexSecond] = temp;
                        }
                    }
                }
                indexStart++;
            }

        }
    }

}
