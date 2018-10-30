package org.xiuyuan.example.datastructure.jdk;

import org.xiuyuan.example.datastructure.jdk.locks.AbstractOwnableSynchronizer;

/**
 * created by helanzhou
 * Date: 2018/10/27
 * Time: 5:15 PM
 */
public class AbstractQueueSynchronized extends AbstractOwnableSynchronizer implements java.io.Serializable {


    private static final long serialVersionUID = 7373984972572414691L;

    protected AbstractQueueSynchronized(){}

    static final class Node {
        static final Node SHARED = new Node();

        static final Node EXCLUSIVE = null;

        static final int CANCELLED = 1;

        static final int SIGNAL = -1;

        static final int CONDITION = -2;

        static final int PROPAGATE = -3;

        volatile int waitStatus;

        volatile Node prev;

        volatile Node next;

        volatile Thread thread;


    }



}
