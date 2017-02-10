public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> base = threeSum(nums, target - nums[i], i + 1);
                for (int j = 0; j < base.size(); j++) {
                    base.get(j).add(nums[i]);
                }
                res.addAll(base);
            }
        }
        return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = start; i < nums.length - 2; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                List<List<Integer>> base = twoSum(nums, target - nums[i], i + 1);
                for (int j = 0; j < base.size(); j++) {
                    base.get(j).add(nums[i]);
                }
                res.addAll(base);
            }
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = target - sum;
            if (diff == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(nums[left]);
                ans.add(nums[right]);
                res.add(ans);
                left += 1;
                right -= 1;
                while (left < right && nums[left] == nums[left - 1]) {
                    left += 1;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right -= 1;
                }
            } else if (diff > 0) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return res;
    }
}