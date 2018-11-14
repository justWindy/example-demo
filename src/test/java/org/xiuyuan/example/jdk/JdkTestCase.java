package org.xiuyuan.example.jdk;

import org.junit.Test;
import org.xiuyuan.example.jdk.thread.RailWay;
import org.xiuyuan.example.jdk.thread.Train;

/**
 * created by helanzhou
 * Date: 2018/11/6
 * Time: 1:55 PM
 */
public class JdkTestCase {

    @Test
    public void testRailWay() {
        final RailWay railWay = new RailWay();
        final long n = 2000000000l;

        new Thread() {
            long lastValue = 0;

            @Override
            public void run() {
                while (lastValue < n) {
                    Train train = railWay.waitTrainOnStation(1);
                    int count = train.goodsCount();

                    for (int i=0; i<count; i++) {
                        lastValue = train.getGoods(i);
                    }
                    railWay.sendTrain();
                }
            }
        }.start();

        final long start = System.nanoTime();
        long i = 0;

        while (i < n) {
            Train train = railWay.waitTrainOnStation(0);
        }
    }

}
