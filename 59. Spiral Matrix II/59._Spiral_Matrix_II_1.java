public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        int count = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (left <= right) {
            for (int i = left; i < right + 1; i++) {
                count++;
                result[top][i] = count;
            }
            if (left == right) {
                break;
            }
            for (int j = top + 1; j < bottom + 1; j++) {
                count++;
                result[j][right] = count;
            }
            for (int k = right - 1; k >= left; k--) {
                count++;
                result[bottom][k] = count;
            }
            for (int l = bottom - 1; l > top; l--) {
                count++;
                result[l][left] = count;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}