package org.xiuyuan.example.jdk.thread;

/**
 * created by helanzhou
 * Date: 2018/11/6
 * Time: 1:48 PM
 */
public class Train {

    public static int CAPACITY = 2 * 1024;

    private final long[] goodsArray;

    private int index;

    public Train() {
        goodsArray = new long[CAPACITY];
    }

    public int goodsCount() {
        return index;
    }

    public void addGoods(long i) {
        goodsArray[index++] = i;
    }

    public long getGoods(int i) {
        index--;
        return goodsArray[i];
    }

}
