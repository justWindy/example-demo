package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-07
 * Time: 23:09
 */
public class Power {

    public static void main(String[] args) {
        Power test = new Power();
        System.out.println(test.power(2.0, 0));
    }

    public double power(double base, int exponent) {

        if (equals(base, 0.0) && exponent == 0) {
            return 0.0;
        }

        if (exponent == 0) {
            return 1.0;
        }

        double result = 0.0;
        if (exponent < 0) {
            result = powerWithUnsigned(base, -exponent);
            return 1 / result;
        }

        result = powerWithUnsigned(base, exponent);

        return result;
    }

    public double powerWithUnsigned(double base, int exponent) {
        double init = base;

        for (int i = 1; i < exponent; i++) {
            init *= base;
        }

        return init;
    }

    public boolean equals(double num1, double num2) {
        if (num1 - num2 < 0.0000001 && num1 - num2 > -0.0000001) {
            return true;
        }

        return false;
    }

}
