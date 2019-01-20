package org.xiuyuan.example.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * created by helanzhou
 * Date: 2018-12-10
 * Time: 11:11
 */
public class LockSupportDemo {

    public static Object obj = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static void main(String[] args) throws InterruptedException{
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();

        System.out.println("thread end");
    }

    public static void testPerson() {
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

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }
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


