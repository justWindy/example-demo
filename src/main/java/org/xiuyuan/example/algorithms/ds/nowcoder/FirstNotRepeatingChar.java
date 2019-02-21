package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.HashMap;

/**
 * 第一次只出现一次的字符
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 11:06
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        int value = new FirstNotRepeatingChar().FirstNotReatingChar("abaccdeff");

        System.out.println(value);
    }

    public int FirstNotReatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapIndex = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], 1 + map.get(chars[i]));
            } else {
                map.put(chars[i], 1);
            }
            mapIndex.put(chars[i], i);
        }

        int min = str.length() - 1;
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                int index = mapIndex.get(entry.getKey());
                if (index < min) {
                    min = index;
                }
            }
        }

        return min;
    }

}
