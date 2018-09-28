package org.xiuyuan.example.loadbalance;

import org.xiuyuan.example.constants.ExampleConstants;

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
public class RoundRobinAlgorithm {

    public static int pos = 0;

    public static String getServer() {
        String server = null;

        if (pos >= ExampleConstants.SERVER_LIST.size()) {
            pos = 0;
        }

        server = ExampleConstants.SERVER_LIST.get(pos);
        pos++;

        return server;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(RoundRobinAlgorithm.getServer());
        }
    }
}
