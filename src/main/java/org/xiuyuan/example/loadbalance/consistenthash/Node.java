package org.xiuyuan.example.loadbalance.consistenthash;

/**
 * @author ray
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 4:24 PM
 */
public interface Node {

    /**
     * get the key used for hash method
     *
     * @returnf the key which will be used for hash
     */
    String getKey();
}
