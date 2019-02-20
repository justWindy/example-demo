package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * 替换空格
 * created by helanzhou
 * Date: 2019-01-06
 * Time: 22:37
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
//        System.out.println(replaceSpace(buffer));

        System.out.println(replaceBlank(buffer));
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

    public static String replaceBlank(StringBuffer str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return str.toString();
        }

        char[] array = str.toString().toCharArray();

        int originalLength = array.length;
        int numberOfBlank = 0;

        for (int i = 0; i < originalLength; i++) {
            if (array[i] == ' ') {
                numberOfBlank++;
            }
        }

        int newLength = originalLength + numberOfBlank * 2;

        char[] newArray = new char[newLength];
        System.arraycopy(array, 0, newArray, 0, originalLength);
        int index1 = originalLength - 1;
        int index2 = newLength - 1;
        while (index1 >= 0 && index2 > index1) {
            if (newArray[index1] == ' ') {
                newArray[index2--] = '0';
                newArray[index2--] = '2';
                newArray[index2--] = '%';
            } else {
                newArray[index2--] = newArray[index1];
            }
            --index1;
        }

        return new String(newArray);
    }

}
