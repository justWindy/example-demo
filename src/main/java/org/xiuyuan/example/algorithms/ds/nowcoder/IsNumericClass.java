package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-12
 * Time: 17:40
 */
public class IsNumericClass {

    public static void main(String[] args) {
        String str1 = "+100";
        String str2 = "5e2";
        String str3 = "-123";
        String str4 = "3.1416";
        String str5 = "-1E-16";
        String str6 = "12e";
        String str7 = "1a3.14";
        String str8 = "1.2.3";
        String str9 = "+-5";
        String str10 = "12e+4.3";
        System.out.println(isNumberic(str10.toCharArray()));
    }

    public static boolean isNumberic(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        int index = 0, length = str.length;
        boolean hasDot = false, hasE = false;

        char first = str[index];
        if (!(first == '-' || first == '+' || Character.isDigit(first))) {
            return false;
        }
        index++;

        int dotIndex = 0, eIndex = 0;
        while (index < length) {
            char value = str[index++];
            if (hasDot && value == '.') {
                return false;
            } else if (value == 'e' || value == 'E') {
                hasE = true;
                eIndex = index;
                if (eIndex == length) {
                    return false;
                }
            } else if (value == '.') {
                hasDot = true;
                dotIndex = index;
                if (eIndex != 0 && dotIndex > eIndex) {
                    return false;
                }
            } else if (value == '-' || value == '+') {
                if (!hasE) {
                    return false;
                } else {
                    if (index - eIndex != 1) {
                        return false;
                    }
                }
            } else if (!Character.isDigit(value)) {
                return false;
            }

        }

        return true;
    }

}
