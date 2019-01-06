package org.xiuyuan.example.design.singleton;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 20:49
 */
public class Singleton_1 {

    private static Singleton_1 instance = new Singleton_1();

    private Singleton_1() {

    }

    public static Singleton_1 getInstance() {
        return instance;
    }

}
