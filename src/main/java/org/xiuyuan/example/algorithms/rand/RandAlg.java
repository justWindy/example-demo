package org.xiuyuan.example.algorithms.rand;

import java.util.Arrays;
import java.util.Random;

/**
 * created by xiuyuan
 * Date: 2018/12/4
 * Time: 11:06 AM
 */
public class RandAlg {

    public static void main(String[] args) {
        int count = 3;
        int sum = 100;

        Random random = new Random();

        int vals[] = new int[count];
        sum -= count;

        for (int i = 0; i < count - 1; i++) {
            vals[i] = random.nextInt(sum);
        }
        vals[count - 1] = sum;

        Arrays.sort(vals);

        for (int i = count - 1; i > 0; i--) {
            vals[i] -= vals[i - 1];
        }

        for (int i = 0; i < count; i++) {
            vals[i]++;
        }

        int result = 0;
        for (int i = 0; i < count; i++) {
            System.out.printf("%4d", vals[i]);
            result += vals[i];
        }

        System.out.println();

        System.out.println(result);
    }

}
