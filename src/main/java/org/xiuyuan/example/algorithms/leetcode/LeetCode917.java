package org.xiuyuan.example.algorithms.leetcode;

/**
 * created by helanzhou
 * Date: 2019-02-01
 * Time: 09:40
 */
public class LeetCode917 {

    public static void main(String[] args) {
        LeetCode917 leetCode917 = new LeetCode917();

        System.out.println(leetCode917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {

        if (S == null || S.length() == 0) {
            return S;
        }

        int low = 0, high = S.length() - 1;
        char[] chars = S.toCharArray();
        while (low <= high) {
            if (Character.isAlphabetic(chars[low]) && Character.isAlphabetic(chars[high])) {
                swap(chars, low, high);
                low++;
                high--;
            } else if (Character.isAlphabetic(chars[low])) {
                high--;
            } else if (Character.isAlphabetic(chars[high])) {
                low++;
            } else {
                low++;
                high--;
            }
        }

        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
