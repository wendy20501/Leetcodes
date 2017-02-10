public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix[0].length;
        int start = 0;
        int end = size - 1;
        while (start < end) {
            //System.out.println("---");
            for (int i = 0; start + i < end; i++) {
                int temp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                //System.out.println("matrix["+start+"]["+(start + i)+"] -> matrix["+(end - i)+"]["+start+"]");
                matrix[end - i][start] = matrix[end][end - i];
                //System.out.println("matrix["+(end - i)+"]["+ start +"] -> matrix["+end+"]["+(end-i)+"]");
                matrix[end][end - i] = matrix[start + i][end];
                //System.out.println("matrix["+end+"]["+(end - i)+"] -> matrix["+(start + i)+"]["+end+"]");
                matrix[start + i][end] = temp;
                //System.out.println("matrix["+(start+i)+"]["+end+"] -> matrix["+start+"]["+(start+i)+"]");
            }
            start += 1;
            end -= 1;
        }
    }
}