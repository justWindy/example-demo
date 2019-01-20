package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-17
 * Time: 19:52
 */
public class DataFlowMedian {

    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        DataFlowMedian dataFlowMedian = new DataFlowMedian();

        dataFlowMedian.Insert(5);
        dataFlowMedian.Insert(2);
        /*dataFlowMedian.Insert(3);
        dataFlowMedian.Insert(4);
        dataFlowMedian.Insert(1);
        dataFlowMedian.Insert(6);
        dataFlowMedian.Insert(7);
        dataFlowMedian.Insert(0);
        dataFlowMedian.Insert(8);*/

        System.out.println(dataFlowMedian.GetMedian());
    }

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {

        if (list.isEmpty()) {
            return 0.0;
        }

        int size = list.size();
        Integer[] array = list.toArray(new Integer[] {});
        sort(array);
        int index = size / 2;
        if (size % 2 == 0) {
            Double value = (array[index] + array[index - 1]) / 2.0;
            return value;
        } else {
            return array[index] * 1.0;
        }

    }

    private boolean less(Integer[] array, int i, int j) {
        return array[i - 1] < array[j - 1];
    }

    private void swap(Integer[] array, int i, int j) {
        int temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    private void sort(Integer array[]) {
        int length = array.length;
        for (int k = length / 2; k >= 1; k--) {
            sink(array, k, length);
        }

        while (length > 1) {
            swap(array, 1, length--);
            sink(array, 1, length);
        }
    }

    private void sink(Integer[] array, int k, int n) {
        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && less(array, j, j + 1)) {
                j++;
            }

            if (!less(array, k, j)) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

}
