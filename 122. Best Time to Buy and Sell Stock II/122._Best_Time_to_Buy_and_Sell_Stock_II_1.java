public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                min = i;
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], dp[min] + prices[i] - prices[min]);
            }
        }
        return dp[prices.length - 1];
    }
}