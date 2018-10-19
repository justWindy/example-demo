package org.xiuyuan.example.basic;

/**
 * created by helanzhou
 * Date: 2018/10/19
 * Time: 3:56 PM
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int y = test.value();

        System.out.println(y);
    }

    public int value() {
        int x = 1;

        try {
            ++x;
            Integer.valueOf("kafka");
            return ++x;
        } catch (Exception e) {

        } finally {
            ++x;
        }

        return x;
    }

}
