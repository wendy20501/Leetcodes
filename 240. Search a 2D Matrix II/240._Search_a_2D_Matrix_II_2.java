public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] < target)
                continue;
            if (matrix[i][0] > target)
                return false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    continue;
            }
        }
        return false;
    }
}