package org.xiuyuan.example.algorithms.leetcode;

/**
 * 岛屿的最大面积
 * created by helanzhou
 * Date: 2019-01-31
 * Time: 21:16
 */
public class LeetCode695 {

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        int[][] grid1 = { { 0, 0, 0, 0, 0, 0, 0, 0 } };

        LeetCode695 leetCode695 = new LeetCode695();

        System.out.println(leetCode695.maxAreaOfIsland(grid1));
    }

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int num = deepSearch(grid, i, j);
                    max = Math.max(num, max);
                }
            }
        }

        return max;
    }

    private int deepSearch(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            int num = 1 + deepSearch(grid, i - 1, j) + deepSearch(grid, i, j - 1) + deepSearch(grid, i + 1, j) +
                      deepSearch(grid, i, j + 1);
            return num;
        } else {
            return 0;
        }
    }
}
