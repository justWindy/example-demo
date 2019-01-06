package org.xiuyuan.example.design.singleton;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 21:01
 */
public class Singleton_4 {

    private volatile static Singleton_4 instance;

    private Singleton_4() {

    }

    public static Singleton_4 getInstance() {
        if (instance == null) {
            synchronized (Singleton_4.class) {
                if (instance == null) {
                    instance = new Singleton_4();
                }
            }
        }

        return instance;
    }

}
