public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int[] temp1 = new int[nums.length - k];
        int[] temp2 = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - k) {
                temp1[i] = nums[i];
            } else {
                temp2[i - (nums.length - k)] = nums[i];
            }
        }
        for (int j = 0; j < k; j++) {
            nums[j] = temp2[j];
        }
        
        for (int l = 0; l < nums.length - k; l++) {
            nums[l + k] = temp1[l];
        }
        return;
    }
}