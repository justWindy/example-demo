package org.xiuyuan.example.datastructure.tree;

/**
 * created by helanzhou
 * Date: 2019-01-20
 * Time: 23:24
 */
public class BinaryNode<T> {

    T          value;
    BinaryNode left;
    BinaryNode right;
    boolean    isFirst;

    public BinaryNode(T ele) {
        this.value = ele;
        left = right = null;
    }

}
