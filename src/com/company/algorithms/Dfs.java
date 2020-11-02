package com.company.algorithms;

// Example of a dfs problem
public class Dfs {

    boolean[][] counted;

    private int dfs(int row, int col, int[][] A, int color) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || counted[row][col] || A[row][col] != color)
            return 0;
        counted[row][col] = true;
        dfs(row - 1, col, A, color);
        dfs(row + 1, col, A, color);
        dfs(row, col - 1, A, color);
        dfs(row, col + 1, A, color);
        return 1;
    }

    public void main(String[] args) {
        int countries = 0;
        int[][] A = new int[][]{{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        counted = new boolean[A.length][A[0].length];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                countries += dfs(row,col,A,A[row][col]);
            }
        }
        System.out.print(countries);
    }
}
