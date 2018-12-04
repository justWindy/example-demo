package org.xiuyuan.example.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by helanzhou
 * Date: 2018/9/28
 * Time: 9:29 AM
 */
public class AlgorithmsDemo {

    private static String testString = "1,2,3";

    private static String regexString = "[(,)*(\\n)*(\\t)*|(,)*(\\n)*|(\\n)*(\\t)*|(,)*(\\t)*|(,)*|(\\n)*|(\\t)*]";

    public static void main(String[] args) {

        String[] array = testString.split("[(,)*|(\\n)*|(\\t)*|(\\r)*]");

        List<Integer> list = Arrays.stream(array).map(value -> Integer.valueOf(value)).collect(Collectors.toList());

        System.out.println(list);
    }

}
