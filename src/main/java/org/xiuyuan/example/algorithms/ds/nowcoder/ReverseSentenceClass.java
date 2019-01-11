package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-11
 * Time: 19:46
 */
public class ReverseSentenceClass {

    public static void main(String[] args) {

        String str = "I am a student.";
        String str1 = " ";

        String result = new ReverseSentenceClass().ReverseSentence(str1);

        System.out.println(result);
    }

    public String ReverseSentence(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        if (str.trim().equals("")) {
            return str;
        }

        String[] strs = str.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]).append(" ");
        }

        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

}
