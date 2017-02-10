public class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        if (prices.length < 2) {
            return 0;
        } else {
            buy[0] = -prices[0];
            buy[1] = Math.max(-prices[0], -prices[1]);
            sell[0] = 0;
            sell[1] = Math.max(sell[0], -prices[0] + prices[1]);
            for (int i = 2; i < prices.length; i++) {
                buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
                sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            }
            return Math.max(buy[prices.length-1], sell[prices.length-1]);
        }
    }
}