public class Solution {
    public int numSquares(int n) {
        List<Integer> lstSquare = new ArrayList<Integer>();
        int i = 1;
        while(i*i <= n) {
            lstSquare.add(i*i);
            i++;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int k = 1; k < n + 1; k++) {
            int min = dp[k - 1] + 1;
            for (int j = 0; j < lstSquare.size(); j++) {
                int cur = lstSquare.get(j);
                if (k >= cur && dp[k - cur] + 1 < min)
                    min = dp[k - cur] + 1;
            }
            dp[k] = min;  
        }
        return dp[n];
    }
}