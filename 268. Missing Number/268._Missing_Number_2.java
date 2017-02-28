public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i;
        }
        
        return xor ^ i;
    }
}