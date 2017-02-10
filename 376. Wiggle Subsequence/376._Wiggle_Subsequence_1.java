public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] differences = new int[nums.length - 1];
        boolean ifUp = false;
        int count = 1;
        boolean init = false;
        for (int i = 1; i < nums.length; i++) {
            differences[i - 1] = nums[i] - nums[i - 1];
            if (!init) {
                if (differences[i - 1] != 0) {
                    ifUp = differences[i - 1] > 0? true : false;
                    count++;
                    init = true;
                } 
            } else if (ifUp) {
                if (differences[i - 1] < 0) {
                    ifUp = false;
                    count++;
                }
            } else {
                if (differences[i - 1] > 0) {
                    ifUp = true;
                    count++;
                }
            }
        }
        return count;
    }
}