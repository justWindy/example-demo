package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-09
 * Time: 18:13
 */
public class VerifySequenceOfBST {

    public static void main(String[] args) {

        int[] array = {5, 7, 6, 9, 11, 10, 8};
        int[] array1 = {7, 4, 6, 5};

        System.out.println(new VerifySequenceOfBST().VerifySquenceOfBST(array1));

    }

    public boolean VerifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return true;
        }

        return verifySequenceOfBST(sequence, sequence.length);

    }

    private boolean verifySequenceOfBST(int[] sequence, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }

        int root = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(sequence, i);
        }

        boolean right = true;
        if (i < length - 1) {
            right = verifySequenceOfBST(sequence, length - 1 - i);
        }

        return (left && right);
    }

}
