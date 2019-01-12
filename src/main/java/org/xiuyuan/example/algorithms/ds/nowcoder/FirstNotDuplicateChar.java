package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 19:00
 */
public class FirstNotDuplicateChar {

    private int[] occurrence = new int[256];
    private int   index      = 0;

    public FirstNotDuplicateChar() {
        for (int i = 0; i < occurrence.length; i++) {
            occurrence[i] = -1;
        }
    }

    public void Insert(char ch) {
        if (occurrence[ch] == -1) {
            occurrence[ch] = index;
        } else if (occurrence[ch] >= 0) {
            occurrence[ch] = -2;
        }
        index++;
    }

    public char FirstAppearingOnce() {

        char ch = '#';
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                ch = (char)i;
                minIndex = occurrence[i];
            }
        }

        return ch;

    }

    int[] array = new int[256];
    StringBuffer buffer = new StringBuffer();

    public void insert(char ch) {
        buffer.append(ch);
        array[ch]++;
    }

    public char firstAppearingOnce() {
        char[] chars = buffer.toString().toCharArray();
        for (char ch : chars) {
            if (array[ch] == 1) {
                return ch;
            }
        }

        return '#';
    }

}
