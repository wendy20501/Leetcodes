public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length && nums[left] == 0) {
            left++;
        }
        while (right >= 0 && nums[right] == 2) {
            right--;
        }
        int temp;
        int mid = left + 1;
        while (mid <= right) {
            if (nums[mid] < nums[left]) {
                swap(nums, mid, left);
                while (left < nums.length && nums[left] == 0) {
                    left++;
                }
                mid = left + 1;
            } else if (nums[mid] > nums[right]) {
                swap(nums, mid, right);
                while (right >= 0 && nums[right] == 2) {
                    right--;
                }
                mid = left + 1;
            } else {
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}