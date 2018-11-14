package org.xiuyuan.example;

import com.alibaba.fastjson.JSONObject;
import org.xiuyuan.example.param.MigrateParam;

/**
 * created by helanzhou
 * Date: 2018/9/22
 * Time: 7:20 PM
 */
public class Example {

    public static void main(String[] args) {
        MigrateParam migrateParam = new MigrateParam();

        migrateParam.setAck(false);
        migrateParam.setChannelQos(50);
        migrateParam.setChannelSize(1);
        migrateParam.setConfirm(true);
        migrateParam.setOrigin("rabbitmq-newbroker-1");
        migrateParam.setOriginQueue("bee-shovel.test.queue.1");
        migrateParam.setOriginVHost("rabbit");
        migrateParam.setDestination("rabbitmq-newbroker-2");
        migrateParam.setDestVHost("erlang");
        migrateParam.setDestQueue("bee-shovel.test.queue.2");

        System.out.println(JSONObject.toJSONString(migrateParam));
    }
}
