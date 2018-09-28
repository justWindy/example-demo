package org.xiuyuan.example.okhttp;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * created by helanzhou
 * Date: 2018/9/22
 * Time: 7:24 PM
 */
public class CredentialTest {

    public static void main(String[] args) {
        String credential = Credentials.basic("****",
                                              "****",
                                              Charset.forName("UTF-8"));

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://st4-xxx-a-12.xxx.yiran.com:15672/api/exchanges")
                .header("Authorization", credential)
                /*.put(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                                        JSONObject.toJSONString("")))*/
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("the request is false");
                return;
            }

            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
