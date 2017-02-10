public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (max < i + 1) {
                break;
            }
            max = Math.max(max, nums[i] + i + 1);
        }
        return max >= nums.length? true : false;
    }
}