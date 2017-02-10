public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int total = 1;
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                total *= nums[i];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (zeroCnt > 1)
                result[j] = 0;
            else if (zeroCnt == 1)
                result[j] = nums[j] == 0? total : 0;
            else
                result[j] = total / nums[j];
        }
        return result;
    }
}