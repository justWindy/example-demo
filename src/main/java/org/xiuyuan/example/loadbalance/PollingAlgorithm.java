package org.xiuyuan.example.loadbalance;

import java.util.Arrays;
import java.util.List;

/**
 * <p>polling algorithm, dispatch the request to server as the request order,
 * it treat all the server equality, no consider of the server's current connections
 * and the load.
 * </p>
 *
 * @author ray
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 1:51 PM
 */
public class PollingAlgorithm {

    public static List<String> serverList = Arrays.asList("192.168.0.1", "192.168.0.2", "192.168.0.3", "192.168.0.4",
                                                          "192.168.0.5", "192.168.0.6", "192.168.0.7", "192.168.0.8");

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
        for (int i = 0; i < 10; i++) {
            System.out.println(PollingAlgorithm.getServer());
        }
    }
}
