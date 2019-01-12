package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 14:52
 */
public class AddClass {

    public static void main(String[] args) {

        System.out.println(add(1, -2));
    }

    public static int add(int num1, int num2) {
        if (num2 > 0) {
            while (num2-- > 0) {
                num1++;
            }
        } else {
            while (num2++ < 0) {
                num1--;
            }
        }

        return num1;
    }

}
