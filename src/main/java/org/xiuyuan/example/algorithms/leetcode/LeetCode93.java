package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-26
 * Time: 17:23
 */
public class LeetCode93 {

    public static void main(String[] args) {

        LeetCode93 leetCode93 = new LeetCode93();

        System.out.println(leetCode93.restoreIpAddress("25525511135"));
    }

    public List<String> restoreIpAddress(String s) {
        ArrayList<String> list = new ArrayList<>();

        if (s == null || s.length() > 12 || s.isEmpty()) {
            return list;
        }

        getIPAddress(s, 0, "", list);

        return list;
    }

    private void getIPAddress(String init, int pos, String ipAddr, ArrayList<String> list) {
        if (init.isEmpty()) {
            return;
        }

        //只能存在4节IP
        if (pos == 3) {
            int addr = Integer.parseInt(init);
            if (init.charAt(0) == '0') {
                if (!(init.length() == 1 && addr == 0)) {
                    return;
                }
            }
            if (addr <= 255) {
                ipAddr = ipAddr + init;
                list.add(ipAddr);
            }
        } else {
            if (init.length() >= 1) {
                getIPAddress(init.substring(1), pos + 1, ipAddr + init.substring(0, 1) + ".", list);
            }

            if (init.length() >= 2 && init.charAt(0) != '0') {
                getIPAddress(init.substring(2), pos + 1, ipAddr + init.substring(0, 2) + ".", list);
            }

            if (init.length() >= 3 && init.charAt(0) != '0') {
                int addr = Integer.parseInt(init.substring(0, 3));
                if (addr <= 255) {
                    getIPAddress(init.substring(3), pos + 1, ipAddr + init.substring(0, 3) + ".", list);
                }
            }
        }
    }

}
