public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        int max = 0;
        int max_element = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mymap.containsKey(nums[i])) {
                mymap.put(nums[i], mymap.get(nums[i]) + 1);
            } else {
                mymap.put(nums[i], 1);
            }
            if (mymap.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
            if (mymap.get(nums[i]) > max) {
                max_element = nums[i];
            }
        }
        return max_element;
    }
}