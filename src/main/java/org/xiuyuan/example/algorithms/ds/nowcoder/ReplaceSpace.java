package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 22:37
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(buffer));

    }


    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return str.toString();
        }

        String value = str.toString();

        str = new StringBuffer(value.replace(" ", "%20"));

        return str.toString();
    }



}
