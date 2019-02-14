package org.xiuyuan.example.algorithms.leetcode;

/**
 * 朋友圈
 * created by helanzhou
 * Date: 2019-02-02
 * Time: 10:43
 */
public class LeetCode547 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };

        int[][] matrix1 = {
                { 1, 1, 0 },
                { 1, 1, 1 },
                { 0, 1, 1 }
        };

        int[][] matrix2 = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 }
        };
        LeetCode547 leetCode547 = new LeetCode547();

        System.out.println(leetCode547.findCircleNum(matrix));
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(M, visited, i);
            }
        }

        return count;
    }

    private void dfs(int[][] matrix, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && visited[j] == 0) {
                dfs(matrix, visited, j);
            }
        }
    }

}
