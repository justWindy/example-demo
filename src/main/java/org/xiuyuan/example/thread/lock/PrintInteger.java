package org.xiuyuan.example.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * created by helanzhou
 * Date: 2018-12-10
 * Time: 13:58
 */
public class PrintInteger {

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.setThreadB(threadB);
        threadB.setThreadA(threadA);


        threadA.start();
        threadB.start();
    }
}

class ThreadA extends Thread {

    private ThreadB threadB;

    public void setThreadB(ThreadB threadB) {
        this.threadB = threadB;
    }

    @Override
    public void run() {
        for (int i = 0; i<100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + ", ");
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        }
        super.run();
    }
}

class ThreadB extends Thread {

    private ThreadA threadA;

    public void setThreadA(ThreadA threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            if (i % 2 != 0) {
                LockSupport.park();
                System.out.print(i + ", ");
                LockSupport.unpark(threadA);
            }
        }
        super.run();
    }
}
