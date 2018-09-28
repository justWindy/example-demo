package org.xiuyuan.example.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 3:54 PM
 */
public class WeightRoundRobin {

    public static  int                  pos = 0;
    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("192.168.0.1", 1);
        map.put("192.168.0.2", 1);
        map.put("192.168.0.3", 4);
        map.put("192.168.0.4", 3);
        map.put("192.168.0.5", 3);
        map.put("192.168.0.6", 2);
    }

    public static String getServer() {
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<>();
        while (iterator.hasNext()) {
            String server = iterator.next();
            Integer weight = map.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }

        String server = null;
        if (pos >= serverList.size()) {
            pos = 0;
        }

        server = serverList.get(pos);
        pos++;

        return server;
    }

}
