public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[i] = nums[i];
                min[i] = nums[i];
            } else {
                max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
                min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            }
            if (max[i] > result) {
                result = max[i];
            }
        }
        return result;
    }
}