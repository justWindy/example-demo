package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 17:00
 */
public class RegexMatch {

    public static void main(String[] args) {

        RegexMatch match = new RegexMatch();

        boolean result = match.match("aaa".toCharArray(), "a.a".toCharArray());

        System.out.println(result);

    }

    public boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }

        return isMatchRecursive(new String(str), new String(pattern));

    }

    public boolean isMatchRecursive(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean firstMatch = (!text.isEmpty()) && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            boolean first = isMatchRecursive(text, pattern.substring(2));
            boolean second = firstMatch && isMatchRecursive(text.substring(1), pattern);
            return first || second;
        } else {
            return firstMatch && isMatchRecursive(text.substring(1), pattern.substring(1));
        }
    }

}
