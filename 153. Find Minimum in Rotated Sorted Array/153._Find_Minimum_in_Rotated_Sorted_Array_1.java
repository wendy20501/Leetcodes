public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            if (nums[right] < nums[right - 1]) {
                return nums[right];
            }
            left++;
            right--;
        }
        return nums[nums.length - 1];
    }
}