package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 18:13
 */
public class LeftRotateStringClass {

    public static void main(String[] args) {
        String str = "abcdefg";
        String str1 = "abcXYZdef";

        String string = new LeftRotateStringClass().LeftRotateString(str1, 3);

        System.out.println(string);
    }

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 0 || n > str.length()) {
            return str;
        }

        int firstStart = 0;
        int firstEnd = n - 1;
        int secondStart = n;
        int secondEnd = str.length() - 1;
        
        char[] chars = str.toCharArray();
        reverse(chars, firstStart, firstEnd);
        reverse(chars, secondStart, secondEnd);
        
        reverse(chars, firstStart, secondEnd);

        return new String(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        if (begin < 0 || begin > end || end > chars.length) {
            return;
        }

        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

}
