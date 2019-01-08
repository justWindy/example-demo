package org.xiuyuan.example.thread.notify;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 17:21
 */
public class WaitNotify {

    static boolean flag = true;
    static Object  lock = new Object();

    Object result;

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait@ " +
                                           new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }

                System.out.println(Thread.currentThread() + " flag is false. running@ " +
                                   new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                                   new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {

                }
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                                   new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;

        while ((result == null) && remaining > 0) {
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }

        return result;
    }

}
