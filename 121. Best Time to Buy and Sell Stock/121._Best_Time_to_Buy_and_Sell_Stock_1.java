public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max_profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max_profit = Math.max(max_profit, prices[i] - min);
        }
        return max_profit;
    }
}