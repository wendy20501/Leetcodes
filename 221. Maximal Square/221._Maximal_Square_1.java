public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] count = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    count[i][j] = Math.min(Math.min(count[i-1][j], count[i-1][j-1]), count[i][j-1]) + 1;
                    result = Math.max(count[i][j], result);
                }
            }
        }
        return result*result;
    }
}