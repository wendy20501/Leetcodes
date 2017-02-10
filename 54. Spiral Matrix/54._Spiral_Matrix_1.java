public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        //System.out.println("left = " + left);
        //System.out.println("right = " + right);
        //System.out.println("top = " + top);
        //System.out.println("bottom = " + bottom);
        while (left <= right && top <= bottom) {
            for (int i = left; i < right + 1; i++) {
                System.out.println("add matrix[" + top + "][" + i + "]");
                result.add(matrix[top][i]);
            }
            if (top == bottom) {
                break;
            }
            for (int j = top + 1; j < bottom + 1; j++) {
                result.add(matrix[j][right]);
            }
            if (left == right) {
                break;
            }
            for (int k = right - 1; k >= left; k--) {
                result.add(matrix[bottom][k]);
            }
            for (int l = bottom - 1; l > top; l--) {
                result.add(matrix[l][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}