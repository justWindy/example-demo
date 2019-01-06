package org.xiuyuan.example.basic;

/**
 * created by helanzhou
 * Date: 2018/10/19
 * Time: 3:56 PM
 */
public class Test {

    public static void main(String[] args) {

        int promotionLevel = Math.abs((int) (10 / 10));

        switch (promotionLevel == 0 ? 0 : 31 - Integer.numberOfLeadingZeros(promotionLevel)) {
            case 0:
                System.out.println("low");
                break;
            case 1:
                System.out.println("high");
                break;
            default:
                System.out.println("disaster");
                break;
        }

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
