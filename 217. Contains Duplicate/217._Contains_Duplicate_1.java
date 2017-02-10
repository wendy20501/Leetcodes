public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setNums = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (setNums.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}