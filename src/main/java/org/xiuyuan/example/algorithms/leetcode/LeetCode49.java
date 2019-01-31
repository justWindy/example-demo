package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 12:32
 */
public class LeetCode49 {

    public static void main(String[] args) {
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        LeetCode49 leetCode49 = new LeetCode49();
        System.out.println(leetCode49.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(str);
        }

        lists.addAll(map.values());

        return lists;
    }

}
