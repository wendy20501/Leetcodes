public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        boolean[] ifContains = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ifContains[nums[i]] = true;
        }
        for (int j = 0; j < ifContains.length; j++) {
            if (!ifContains[j])
                return j;
        }
        return nums.length;
    }
}