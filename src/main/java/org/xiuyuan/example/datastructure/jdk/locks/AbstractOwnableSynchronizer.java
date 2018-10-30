package org.xiuyuan.example.datastructure.jdk.locks;

/**
 * created by helanzhou
 * Date: 2018/10/27
 * Time: 6:00 PM
 */
public class AbstractOwnableSynchronizer implements java.io.Serializable {

    private static final long serialVersionUID = 3737899427754241961L;

    private transient Thread exclusiveOwnerThread;

    protected AbstractOwnableSynchronizer() {
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

}
