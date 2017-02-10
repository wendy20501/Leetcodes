public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        } else if (nums.length == 3) {
            int res = 0;
            for (int i = 0; i < 3; i++) {
                res += nums[i];
            }
            return res;
        }
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
       // System.out.println(max);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int diff = target - (nums[i] + nums[left] + nums[right]);
                if (Math.abs(closest) > Math.abs(diff)) {
                    closest = diff;
                }
                if (diff == 0) {
                    return target;
                } else if (diff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - closest;
    }
}