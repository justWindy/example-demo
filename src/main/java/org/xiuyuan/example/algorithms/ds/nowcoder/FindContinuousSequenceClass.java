package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 17:37
 */
public class FindContinuousSequenceClass {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new FindContinuousSequenceClass().FindContinuousSequence(100);

        System.out.println(lists);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if (sum < 3) {
            return listAll;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                listAll.add(addSequenceList(small, big));
            }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;

                if (curSum == sum) {
                    listAll.add(addSequenceList(small, big));
                }
            }

            big++;
            curSum += big;
        }

        return listAll;
    }

    private ArrayList<Integer> addSequenceList(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        return list;
    }

}
