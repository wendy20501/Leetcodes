public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 0;
        int current = 0;
        int newpos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                current = nums[i];
                count += 1;
                newpos += 1;
            } else if (nums[i] != current) {
                nums[newpos] = nums[i];
                current = nums[i];
                count += 1;
                newpos += 1;
            }
        }
        return count;
    }
}