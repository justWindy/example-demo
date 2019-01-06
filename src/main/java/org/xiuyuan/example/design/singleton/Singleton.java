package org.xiuyuan.example.design.singleton;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 21:03
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {

        private static final Singleton sInstance = new Singleton();
    }

}
