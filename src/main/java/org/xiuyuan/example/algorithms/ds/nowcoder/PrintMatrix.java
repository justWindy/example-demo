package org.xiuyuan.example.algorithms.ds.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * created by helanzhou
 * Date: 2019-01-08
 * Time: 21:40
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] array = {
                { 1, 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7 }
        };

        PrintMatrix matrix = new PrintMatrix();
        List<Integer> list = matrix.printMatrix(array);
        System.out.println(list);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null) {
            return null;
        }

        int row = matrix.length;
        if (row == 0) {
            return null;
        }

        int column = matrix[0].length;
        if (column == 0) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        while (column > start * 2 && row > start * 2) {
            printMatrixInCircle(matrix, column, row, start, list);
            start++;
        }

        return list;
    }

    private void printMatrixInCircle(int[][] matrix, int column, int row, int start, ArrayList<Integer> list) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }

        //从左到右打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }

        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }

        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; --i) {
                list.add(matrix[i][start]);
            }
        }
    }

}
