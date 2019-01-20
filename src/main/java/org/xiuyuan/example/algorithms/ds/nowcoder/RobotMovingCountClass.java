package org.xiuyuan.example.algorithms.ds.nowcoder;

/**
 * created by helanzhou
 * Date: 2019-01-18
 * Time: 23:01
 */
public class RobotMovingCountClass {

    public static void main(String[] args) {

        System.out.println(new RobotMovingCountClass().movingCount(18, 30, 50));
    }

    public int movingCount(int threshold, int rows, int cols) {

        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        return movingCountCore(threshold, rows, cols, 0, 0, visited);

    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;

        if (check(threshold, rows, cols, row, col, visited)) {
            int index = row * cols + col;
            visited[index] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited);
        }

        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int index = row * cols + col;

        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[index] &&
            (getDigitsSum(row) + getDigitsSum(col)) <= threshold) {
            return true;
        }

        return false;
    }

    public int getDigitsSum(int num) {
        if (num <= 0) {
            return 0;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

}
