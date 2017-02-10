public class NumArray {
    int[] mynums;
    public NumArray(int[] nums) {
        mynums = new int[nums.length + 1];
        mynums[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            mynums[i + 1] = mynums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return mynums[j + 1] - mynums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);