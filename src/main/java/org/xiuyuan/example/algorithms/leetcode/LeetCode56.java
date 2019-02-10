package org.xiuyuan.example.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-02-05
 * Time: 21:55
 */
public class LeetCode56 {

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();

        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        Interval interval5 = new Interval(1, 4);
        Interval interval6 = new Interval(0, 1);

        Interval interval7 = new Interval(2, 3);
        Interval interval8 = new Interval(5, 5);
        Interval interval9 = new Interval(2, 2);
        Interval interval10 = new Interval(3, 4);
        Interval interval11 = new Interval(3, 4);

        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);

        List<Interval> list1 = new ArrayList<>();
        list1.add(interval5);
        list1.add(interval6);

        List<Interval> list2 = new ArrayList<>();
        list2.add(interval7);
        list2.add(interval8);
        list2.add(interval9);
        list2.add(interval10);
        list2.add(interval11);

        System.out.println(leetCode56.merge(list1));
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return list;
        }

        merge(intervals, list);

        List<Interval> result  = new ArrayList<>();
        merge(list, result);

        return result;
    }

    private void merge(List<Interval> intervals, List<Interval> list) {
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval init = intervals.get(i);
            for (int j = 0; j < list.size(); j++) {
                Interval des = list.get(j);
                if (init.start >= des.start && init.end <= des.end) {
                    break;
                }

                if ((des.end >= init.start && des.end <= init.end) || (init.end >= des.start && init.end <= des.end)) {
                    list.remove(j--);
                    int start = Math.min(init.start, des.start);
                    int end = Math.max(init.end, des.end);
                    des = new Interval(start, end);
                    intervals.add(des);
                    list.add(des);
                } else {
                    if (j == list.size() - 1) {
                        list.add(init);
                        break;
                    }
                }
            }
        }
    }

    private static class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

}
