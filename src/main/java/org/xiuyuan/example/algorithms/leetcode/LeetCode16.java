package org.xiuyuan.example.algorithms.leetcode;

import java.util.Arrays;

/**
 * created by helanzhou
 * Date: 2019-01-27
 * Time: 22:47
 */
public class LeetCode16 {

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        LeetCode16 leetCode16 = new LeetCode16();

        leetCode16.headSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (result == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum <= target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }

    public void headSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        buildMaxHeap(array);

        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);

            sink(array, i, 0);
        }
    }

    public void buildMaxHeap(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        int cursor = array.length / 2;
        for (int i = cursor; i >= 0; i--) {
            sink(array, array.length, i);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private void minHeap(int[] array, int heapSize, int index) {
        int left = left(index);
        int right = right(index);
        int maxValue = index;

        if (left < heapSize && array[left] < array[maxValue]) {
            maxValue = left;
        }

        if (right < heapSize && array[right] < array[maxValue]) {
            maxValue = right;
        }

        if (maxValue != index) {
            swap(array, index, maxValue);
            minHeap(array, heapSize, maxValue);
        }
    }

    private void sink(int[] array, int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;

            if (j < n - 1 && array[j] < array[j + 1]) {
                j++;
            }

            if (array[k] <= array[j]) {
                break;
            }
            swap(array, k, j);
            k = j;
        }
    }

    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxValue = index;

        if (left < heapSize && array[left] > array[maxValue]) {
            maxValue = left;
        }

        if (right < heapSize && array[right] > array[maxValue]) {
            maxValue = right;
        }

        if (maxValue != index) {
            swap(array, index, maxValue);
            maxHeap(array, heapSize, maxValue);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
