package org.xiuyuan.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * created by helanzhou
 * Date: 2018/9/22
 * Time: 7:20 PM
 */
public class Example {

    public static void main(String[] args) {

        File file = new File("./test.log");

        Map<String, Integer> map = new HashMap<>();

        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {

                if (map.keySet().contains(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.forEach((k, v) -> {
            System.out.println(k);
        });
    }
}
