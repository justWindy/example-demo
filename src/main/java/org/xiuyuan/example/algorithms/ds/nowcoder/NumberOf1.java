package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 二进制中1的个数
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 22:38
 */
public class NumberOf1 {

    public static void main(String[] args) {

    }

    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

}
