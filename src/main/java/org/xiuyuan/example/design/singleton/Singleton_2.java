package org.xiuyuan.example.design.singleton;

/**
 * no thread-safe, not recommend.
 *
 * @author ray
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 20:55
 */
public class Singleton_2 {

    private static Singleton_2 instance;

    private Singleton_2() {

    }

    public static Singleton_2 getInstance() {
        if (instance == null) {
            instance = new Singleton_2();
        }

        return instance;
    }
}
