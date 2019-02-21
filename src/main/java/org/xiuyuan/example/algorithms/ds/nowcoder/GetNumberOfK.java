package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 数字在排序数组中出现的次数
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 15:49
 */
public class GetNumberOfK {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int result = new GetNumberOfK().GetNumberOfK(array, 3);

        System.out.println(result);
    }

    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int start = 0;
        int end = array.length - 1;

        int startIndex = getFirstK(array, array.length, k, start, end);
        int endIndex = getLastK(array, array.length, k, start, end);

        if (startIndex > -1 && endIndex > -1) {
            return endIndex - startIndex + 1;
        }

        return 0;
    }

    private int getFirstK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getFirstK(array, length, k, start, end);
    }

    private int getLastK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if ((middleIndex < length - 1 && array[middleIndex + 1] != k) || middleIndex == length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }

        return getLastK(array, length, k, start, end);
    }

}
