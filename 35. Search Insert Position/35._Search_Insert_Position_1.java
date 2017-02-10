public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle = -1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (middle == -1) {
            return 0;
        } else if (nums[middle] > target) {
            return middle;
        } else {
            return middle + 1;
        }
    }
}