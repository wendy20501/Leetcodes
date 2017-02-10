public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0 || nums == null)
            return result;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = dp[i] > dp[max] ? i : max;
        }
        
        int temp = nums[max];
        int currentDp = dp[max];
        for (int k = max; k >= 0; k--) {
            if (temp % nums[k] == 0 && dp[k] == currentDp) {
                result.add(nums[k]);
                temp = nums[k];
                currentDp--;
            }
        }
        return result;
    }
}