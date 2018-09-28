package org.xiuyuan.example.loadbalance;

import java.util.Arrays;
import java.util.List;

/**
 * 轮训算法, 将请求按照顺序轮流的分配到服务器上, 均衡对待每一台后端的服务器, 不关心服务器的连接数和负载情况
 *
 * @author ray
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 1:51 PM
 */
public class PollingAlgorithm {

    public static List<String> serverList = Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3", "192.168.0.4",
                                                          "192.168.0.5");

    public static int pos = 0;

    public static String getServer() {
        String server = null;

        if (pos >= serverList.size()) {
            pos = 0;
        }

        server = serverList.get(pos);
        pos++;

        return server;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(PollingAlgorithm.getServer());
        }
    }
}
