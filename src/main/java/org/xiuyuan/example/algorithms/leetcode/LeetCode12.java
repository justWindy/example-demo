package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 16:25
 */
public class LeetCode12 {

    public static void main(String[] args) {

        LeetCode12 leetCode12 = new LeetCode12();

        System.out.println(leetCode12.intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        if (num < 1 || num > 3999) {
            return builder.toString();
        }

        if (num >= 1000) {
            int thousand = num / 1000;
            int redundant = num % 1000;

            for (int i = 0; i < thousand; i++) {
                builder.append("M");
            }
            convert2Hundred(redundant, builder);
        } else if (num >= 100) {
            convert2Hundred(num, builder);
        } else if (num >= 10) {
            convert2Ten(num, builder);
        } else {
            convert2Unit(num, builder);
        }

        return builder.toString();
    }

    public void convert2Hundred(int num, StringBuilder builder) {
        int hundred = num / 100;
        int redundant = num % 100;

        if (hundred <= 3) {
            for (int i = 0; i < hundred; i++) {
                builder.append("C");
            }
        } else if (hundred == 4) {
            builder.append("CD");
        } else if (hundred < 9) {
            builder.append("D");
            for (int i = 6; i <= hundred; i++) {
                builder.append("C");
            }
        } else {
            builder.append("CM");
        }
        convert2Ten(redundant, builder);
    }

    public void convert2Ten(int num, StringBuilder builder) {
        int ten = num / 10;
        int redundant = num % 10;

        if (ten <= 3) {
            for (int i = 0; i < ten; i++) {
                builder.append("X");
            }
        } else if (ten == 4) {
            builder.append("XL");
        } else if (ten < 9) {
            builder.append("L");
            for (int i = 6; i <= ten; i++) {
                builder.append("X");
            }
        } else {
            builder.append("XC");
        }
        convert2Unit(redundant, builder);
    }

    public void convert2Unit(int num, StringBuilder builder) {

        if (num <= 3) {
            for (int i = 0; i < num; i++) {
                builder.append("I");
            }
        } else if (num == 4) {
            builder.append("IV");
        } else if (num < 9) {
            builder.append("V");
            for (int i = 6; i <= num; i++) {
                builder.append("I");
            }
        } else {
            builder.append("IX");
        }
    }

}
