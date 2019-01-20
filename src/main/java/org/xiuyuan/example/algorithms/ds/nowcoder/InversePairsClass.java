package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-18
 * Time: 23:17
 */
public class InversePairsClass {

    public static void main(String[] args) {
        int[] array = { 7, 5, 6, 4 };

        System.out.println(new InversePairsClass().InversePairs(array));
    }

    public int InversePairs(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return InversePairsCore(array, copy, 0, array.length - 1);

    }

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int mid = (end - start) / 2;
        int left = InversePairsCore(copy, array, start, start + mid) % 1000000007;
        int right = InversePairsCore(copy, array, start + mid + 1, end) % 1000000007;

        int i = start + mid;
        int j = end;
        int index = end;

        int count = 0;
        while (i >= start && j >= start + mid + 1) {
            if (array[i] > array[j]) {
                copy[index] = array[i];
                index--;
                i--;
                count += j - (start + mid);
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[index] = array[j];
                index--;
                j--;
            }
        }

        for (; i >= start; ) {
            copy[index] = array[i];
            index--;
            i--;
        }

        for (; j >= start + mid + 1; ) {
            copy[index] = array[j];
            index--;
            j--;
        }

        return (count + left + right) % 1000000007;
    }

}
