public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            j++;
            while (sum >= s) {
                min = Math.min(j - i, min);
                sum -= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}