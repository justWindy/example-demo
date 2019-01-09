package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-09
 * Time: 11:20
 */
public class StackPopOrder {

    public static void main(String[] args) {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 2, 1};

        System.out.println(IsPopOrder(push, pop));

    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        for (int i = 0, j = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
