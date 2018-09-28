package org.xiuyuan.example.loadbalance.consistenthash;

/**
 * @author ray
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 4:30 PM
 */
public interface HashFunction {

    long hash(String key);

}
