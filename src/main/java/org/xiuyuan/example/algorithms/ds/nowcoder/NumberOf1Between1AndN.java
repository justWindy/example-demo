package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 21:53
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        int result = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(13);

        System.out.println(result);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <=0) {
            return 0;
        }

        char[] chars = String.valueOf(n).toCharArray();
        return numberOf1(chars, 0);
    }

    private int numberOf1(char[] chars, int low) {
        if (low == chars.length) {
            return 0;
        }

        int first = chars[low] - '0';
        int length = chars.length - low;

        if (length == 1 && first == 0) {
            return 0;
        } else if (length == 1 && first > 0) {
            return 1;
        }

        int numAtFirst = 0;
        if (first > 1) {
            numAtFirst = power10(length - 1);
        } else if (first == 1) {
            numAtFirst = Integer.valueOf(String.valueOf(chars, low + 1, length - 1)) + 1;
        }

        int numOfOther = first * (length - 1) * power10(length - 2);
        int numRecursive = numberOf1(chars, low + 1);

        return numAtFirst + numOfOther + numRecursive;

    }

    private int power10(int n) {
        int r = 1;
        for (int i = 0; i < n; i++) {
            r *= 10;
        }
        return r;
    }
}
