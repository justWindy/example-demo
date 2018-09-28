package org.xiuyuan.example.loadbalance.consistenthash;

/**
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 4:26 PM
 */
public class VirtualNode<T extends Node> implements Node {

    final T   physicalNode;
    final int replicaIndex;

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.physicalNode = physicalNode;
        this.replicaIndex = replicaIndex;
    }

    @Override
    public String getKey() {
        return physicalNode.getKey() + "-" + replicaIndex;
    }

    public boolean isVirtualNodeOf(T pNode) {
        return physicalNode.getKey().equals(pNode.getKey());
    }

    public T getPhysicalNode() {
        return physicalNode;
    }
}
