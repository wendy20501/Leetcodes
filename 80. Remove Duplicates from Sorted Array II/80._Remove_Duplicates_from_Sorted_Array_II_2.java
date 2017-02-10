public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int current = nums[0];
        result.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
                if (count < 2) {
                    result.add(nums[i]);
                }
            } else {
                count = 0;
                current = nums[i];
                result.add(nums[i]);
            }
            
        }
        for (int j = 0; j < result.size(); j++) {
            nums[j] = result.get(j);
        }
        return result.size();
    }
}