public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        if (bottom < 0) {
            return false;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][left] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][left] == target) {
                return true;
            } else {
                top = mid + 1;
            }
        }
        //System.out.println("top : " + top);
        //System.out.println("bottom : " + bottom);
        if (bottom < 0) {
            return false;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[bottom][mid] > target) {
                right = mid - 1;
            } else if (matrix[bottom][mid] == target) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}