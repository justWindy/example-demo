package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * created by helanzhou
 * Date: 2019-01-10
 * Time: 19:35
 */
public class StringPermutation {

    public static void main(String[] args) {
        ArrayList<String> list = new StringPermutation().Permutation("abc");

        System.out.println(list);
    }

    public ArrayList<String> Permutation(String str) {
        HashSet<String> hashSet = new HashSet<>();
        permutation(str.toCharArray(), 0, str.length() - 1, hashSet);
        ArrayList<String> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        return list;
    }

    public void permutation(char[] array, int from, int to, HashSet<String> list) {
        if (from == to) {
            list.add(new String(array));
        } else {
            for (int i = from; i <= to; i++) {
                swap(array, i, from);
                permutation(array, from + 1, to, list);
                swap(array, from, i);
            }
        }
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
