package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 15:04
 */
public class StringToIntClass {

    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483647"));
        System.out.println(Integer.parseInt("+2147483647"));

    }

    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int result = 0;
        int max = -Integer.MAX_VALUE;
        int index = 0, len = str.length();
        boolean negative = true;
        int multmin;
        int digit;

        char first = str.charAt(index);
        if (first < '0') {
            if (first == '-') {
                negative = false;
                max = Integer.MIN_VALUE;
            } else if (first != '+') {
                return 0;
            }

            if (len == 1) {
                return 0;
            }
            index++;
        }
        multmin = max / 10;
        while (index < len) {
            digit = Character.digit(str.charAt(index++), 10);
            if (digit < 0) {
                return 0;
            }

            if (result < multmin) {
                return 0;
            }

            result *= 10;
            if (result < max + digit) {
                return 0;
            }

            result -= digit;
        }

        return (negative) ? -result : result;
    }

}
