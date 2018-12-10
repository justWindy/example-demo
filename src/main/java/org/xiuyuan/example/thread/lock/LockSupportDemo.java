package org.xiuyuan.example.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * created by helanzhou
 * Date: 2018-12-10
 * Time: 11:11
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        Person person = new Person();

        Thread thread = new Thread(() -> {
            person.walk();
        });
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("3 seconds going, i am liberate.");
        LockSupport.unpark(thread);
    }


}

class Person {

    public void walk() {
        Thread current = Thread.currentThread();

        System.out.println(current.getName() + " waking.... front is blocked.");

        LockSupport.park();
        System.out.println(current.getName() + " can walk again.");
    }
}


