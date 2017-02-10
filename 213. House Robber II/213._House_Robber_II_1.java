public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) 
            return 0;
        else if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] nums, int low, int high) {
        int include = 0;
        int exclude = 0;
        
        for (int j = low; j <= high; j++) {
            int i = include;
            int e = exclude;
            include = e + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }
}