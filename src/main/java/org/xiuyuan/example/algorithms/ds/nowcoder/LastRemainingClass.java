package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 14:16
 */
public class LastRemainingClass {

    public static void main(String[] args) {

        System.out.println(new LastRemainingClass().LastRemaining_Solution(10, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

}
