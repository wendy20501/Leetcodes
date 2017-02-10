public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        return 0;
                    }
                    dp[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else{
                    dp[i][j] = 0;
                    if (i != 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j != 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}