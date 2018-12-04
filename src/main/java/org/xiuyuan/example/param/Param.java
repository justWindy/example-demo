package org.xiuyuan.example.param;

/**
 * created by helanzhou
 * Date: 2018/11/13
 * Time: 5:15 PM
 */
public class Param {

    /**
     * channel的num
     */
    private Integer channelSize;
    /**
     * 单个channel的Qos
     */
    private Integer channelQos;
    /**
     * 是否确认
     */
    private Boolean isAck;
    /**
     * 目标集群
     */
    private String  destination;
    /**
     * 目标虚拟主机
     */
    private String  destVHost;
    /**
     * 目标队列
     */
    private String  destQueue;
    /**
     * 原始集群
     */
    private String  origin;
    /**
     * 原虚拟主机
     */
    private String  originVHost;
    /**
     * 原队列
     */
    private String  originQueue;
    /**
     * 是否是发送确认模式
     */
    private Boolean isConfirm;

    public Integer getChannelSize() {
        return channelSize;
    }

    public void setChannelSize(Integer channelSize) {
        this.channelSize = channelSize;
    }

    public Integer getChannelQos() {
        return channelQos;
    }

    public void setChannelQos(Integer channelQos) {
        this.channelQos = channelQos;
    }

    public Boolean getAck() {
        return isAck;
    }

    public void setAck(Boolean ack) {
        isAck = ack;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestVHost() {
        return destVHost;
    }

    public void setDestVHost(String destVHost) {
        this.destVHost = destVHost;
    }

    public String getDestQueue() {
        return destQueue;
    }

    public void setDestQueue(String destQueue) {
        this.destQueue = destQueue;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginVHost() {
        return originVHost;
    }

    public void setOriginVHost(String originVHost) {
        this.originVHost = originVHost;
    }

    public String getOriginQueue() {
        return originQueue;
    }

    public void setOriginQueue(String originQueue) {
        this.originQueue = originQueue;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setConfirm(Boolean confirm) {
        isConfirm = confirm;
    }
}
