package org.xiuyuan.example.algorithms.ratelimite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * created by helanzhou
 * Date: 2018/11/19
 * Time: 11:40 AM
 */
public class AccessClient {

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    public static String sendGet(URL realUrl) {
        String result = "";

        BufferedReader in = null;
        try {
            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            connection.connect();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("get request occurs error." + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result;
    }

    public void access() throws Exception {
        final URL url = new URL("http://localhost:8080/guavalimitdemo/access");

        for (int i=0; i<10; i++) {
            fixedThreadPool.submit(() -> {
                System.out.println(sendGet(url));
            });
        }

        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }



}
