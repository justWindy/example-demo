package org.xiuyuan.example;

import com.alibaba.fastjson.JSONObject;
import org.xiuyuan.example.param.Param;

/**
 * created by helanzhou
 * Date: 2018/9/22
 * Time: 7:20 PM
 */
public class Example {

    public static void main(String[] args) {
        Param param = new Param();

        System.out.println(JSONObject.toJSONString(param));
    }
}
