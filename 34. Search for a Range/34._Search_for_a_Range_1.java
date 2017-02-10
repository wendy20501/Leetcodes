public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int pos = binarySearch(nums, 0, nums.length - 1, target);
        if (pos == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        } else if (pos == 0) {
            res[0] = pos;
            res[1] = findLast(nums, pos, nums.length - 1, target);
            
        } else if (pos == nums.length - 1) {
            res[0] = findFirst(nums, 0, pos, target);
            res[1] = pos;
        } else {
            res[0] = findFirst(nums, 0, pos, target);
            res[1] = findLast(nums, pos, nums.length - 1, target);
        }
        return res;
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
    
    private int findFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int ans = binarySearch(nums, start, end, target);
            if (ans == -1) {
                return start;
            }
            if (ans != start && nums[ans - 1] == nums[ans]) {
                end = ans - 1;
            } else {
                return ans;
            }
        }
        return start;
    }
    
    private int findLast(int[] nums, int start, int end, int target) {
        while (start < end) {
            int ans = binarySearch(nums, start, end, target);
            if (ans == -1) {
                return end;
            }
            if (ans != end && nums[ans + 1] == nums[ans]) {
                start = ans + 1;
            } else {
                return ans;
            }
        }
        return end;
    }
}