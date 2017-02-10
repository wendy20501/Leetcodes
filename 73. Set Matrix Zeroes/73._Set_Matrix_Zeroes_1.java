public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        List<Integer> zero_row = new ArrayList<Integer>();
        List<Integer> zero_col = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zero_row.add(i);
                    zero_col.add(j);
                }
            }
        }
        if (zero_row.size() != 0) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (zero_row.contains(i) || zero_col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return;
    }
}