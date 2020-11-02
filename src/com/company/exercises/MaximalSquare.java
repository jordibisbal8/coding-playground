package com.company.exercises;

/** Dynamic programming: Is a method for solving a complex problem by breaking it down into a collection of simpler subproblems, solving these problems just
 * once and storing their solutions using a memory-based data structure
 * Problem: Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area
 */
public class MaximalSquare {
    // Time complexity : O(mn)O(mn). Single pass.
    // Space complexity : O(mn)O(mn). Another matrix of same size is used for dp.
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int DP[][] = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (matrix[i-1][j-1] == '1') { // Because it is the i-1 and j-1 for the original one (draw if needed)
                    // we take the min because if 1  0
                    //                            1 (1) as there is a zero it is not squared!
                    DP[i][j] = Math.min(Math.min(DP[i-1][j], DP[i][j-1]), DP[i-1][j-1]) + 1;
                    result = Math.max(result, DP[i][j]);
                }
            }
        }
        return result * result;
    }

    public static int maximalSquareOptimized(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0, prev = 0; // the i-1 & j-1 can be stored with a prev element, no need to have dp[m][n]
        int dp[] = new int[n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    result = Math.max(result, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalSquareOptimized(matrix));
    }
}
