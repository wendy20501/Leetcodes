public class Solution {
    public void nextPermutation(int[] nums) {
        int current = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1 && nums[i] < current) {
                //System.out.println("partitionPos:" + i);
                int changePos = getChangePos(i, nums);
                //System.out.println("changePos:" + changePos);
                if (changePos != -1) {
                    int temp = nums[i];
                    nums[i] = nums[changePos];
                    nums[changePos] = temp;
                    reverseFromPartitionPos(i, nums);
                } 
                break;
            }
            current = nums[i];
            if (i == 0) {
                Arrays.sort(nums);
            }
        }
    }
    private int getChangePos(int partitionPos, int[] nums) {
        for (int j = nums.length - 1; j > partitionPos; j--) {
            if (nums[j] > nums[partitionPos]) {
                return j;
            }
        }
        return -1;
    }
    private void reverseFromPartitionPos(int partitionPos, int[] nums) {
        int left = partitionPos + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}