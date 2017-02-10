public class NumMatrix {
    int[][] myMatrix;
    public NumMatrix(int[][] matrix) {
        myMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            myMatrix[i] = new int[matrix[i].length + 1];
            myMatrix[i][0] = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                myMatrix[i][j + 1] = myMatrix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            sum = sum + myMatrix[i][col2 + 1] - myMatrix[i][col1];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);