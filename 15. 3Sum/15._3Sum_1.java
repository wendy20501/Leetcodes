public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item;
        Arrays.sort(nums);
        if (nums.length < 3) {
            return result;
        }
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        int third = 0 - (nums[i] + nums[j]);
                        if (third == nums[j] && nums[j] == nums[j+1]) {
                            item = new ArrayList<Integer>();
                            item.add(nums[i]);
                            item.add(nums[j]);
                            item.add(third);
                            result.add(item);
                        } else if (third > nums[j] && third <= max) {
                            for (int k = j + 1; k < nums.length; k++) {
                                if (third == nums[k]) {
                                    item = new ArrayList<Integer>();
                                    item.add(nums[i]);
                                    item.add(nums[j]);
                                    item.add(third);
                                    result.add(item);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}