package org.xiuyuan.example.jdk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by helanzhou
 * Date: 2018/10/8
 * Time: 4:25 PM
 */
public class ConcurrentHashMapDemo {


    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();

        map.put("kafka", "a");
        map.put("kafka", "b");

    }

}
