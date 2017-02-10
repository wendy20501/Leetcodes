public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                max = dp[i];
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}