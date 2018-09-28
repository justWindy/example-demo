package org.xiuyuan.example.loadbalance;

import org.xiuyuan.example.constants.ExampleConstants;

import java.util.Random;

/**
 * <p>By system random method, to select one server of the server list,
 * if the invoke frequency is big enough, the result would be the same as round-robin algorithm.
 * </p>
 *
 * @author ray
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 2:07 PM
 */
public class RandomAlgorithm {

    public static String getServer() {
        String server = null;

        Random random = new Random();
        int randPosition = random.nextInt(ExampleConstants.SERVER_LIST.size());

        server = ExampleConstants.SERVER_LIST.get(randPosition);

        return server;
    }

}
