package org.xiuyuan.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by helanzhou
 * Date: 2018-12-08
 * Time: 16:23
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();

        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();



    }

}
