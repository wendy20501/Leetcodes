public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] dp = new int[height * width];
        int[] current = new int[height];
        int count = 0;
        while (count < k) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < height; i++) {
                //System.out.println("i = " + i);
                if (current[i] < width && matrix[i][current[i]] < min) {
                    min = matrix[i][current[i]];
                    index = i;
                }
            }
            dp[count] = min;
            count++;
            current[index]++;
        }
        return dp[k - 1];
    }
}