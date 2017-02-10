public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    if (i != 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                    }
                    if (j != 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                    }
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}