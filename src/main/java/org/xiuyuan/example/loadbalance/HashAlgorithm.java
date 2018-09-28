package org.xiuyuan.example.loadbalance;

import org.xiuyuan.example.constants.ExampleConstants;

/**
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 3:18 PM
 */
public class HashAlgorithm {

    public static String getServer(String ip) {

        String server = null;

        int hashCode = ip.hashCode();

        int pos = hashCode % ExampleConstants.SERVER_LIST.size();

        server = ExampleConstants.SERVER_LIST.get(pos);

        return server;
    }

}
