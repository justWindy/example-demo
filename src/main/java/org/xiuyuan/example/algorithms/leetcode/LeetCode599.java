package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个列表的最小索引总和
 * <p>
 * created by helanzhou
 * Date: 2019-02-11
 * Time: 16:47
 */
public class LeetCode599 {

    public static void main(String[] args) {
        String[] list1 = {
                "Shogun", "Tapioca Express", "Burger King", "KFC"
        };

        String[] list2 = {
                "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
        };

        String[] list3 = {
                "Shogun", "Tapioca Express", "Burger King", "KFC"
        };

        String[] list4 = {
                "KFC", "Shogun", "Burger King"
        };

        LeetCode599 leetCode599 = new LeetCode599();

        System.out.println(Arrays.toString(leetCode599.findRestaurant(list3, list4)));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> restMap = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            restMap.put(list1[i], 1);
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (restMap.containsKey(list2[i])) {
                restMap.put(list2[i], restMap.get(list2[i]) + 1);
            }
            map2.put(list2[i], i);
        }

        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : restMap.entrySet()) {
            if (entry.getValue() >= 2) {
                int indexValue = map1.get(entry.getKey()) + map2.get(entry.getKey());

                if (min == indexValue) {
                    list.add(entry.getKey());
                } else if (min > indexValue) {
                    list.clear();
                    list.add(entry.getKey());
                    min = indexValue;
                }
            }
        }

        return list.toArray(new String[] {});
    }
}
