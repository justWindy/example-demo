package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 14:34
 */
public class SumClass {

    public static void main(String[] args) {
        int n = 10;

        SumClass sumClass = new SumClass();
        System.out.println(sumClass.sum(10));
        System.out.println(sumClass.Sum_Solution(10));
    }

    public int Sum_Solution(int n) {

        return (int) (Math.pow(n, 2) + n) >> 1;
    }

    public int sum(int n) {
        int sum = n;

        boolean result = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }

}
