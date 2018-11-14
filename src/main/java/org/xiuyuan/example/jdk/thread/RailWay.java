package org.xiuyuan.example.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by helanzhou
 * Date: 2018/11/6
 * Time: 1:47 PM
 */
public class RailWay {

    private final Train train = new Train();

    private final AtomicInteger stationIndex = new AtomicInteger();

    private int stationCount = 21;

    public Train waitTrainOnStation(final int stationNo) {
        while (stationIndex.get() % stationCount != stationNo) {
            Thread.yield();
        }

        return train;
    }

    public void sendTrain() {
        stationIndex.getAndIncrement();
    }

}
