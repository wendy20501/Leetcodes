class Solution {
public:
    int missingNumber(vector<int>& nums) {
        if (nums.empty() || nums.size() == 0)
            return 0;
        int XOR = 0, i = 0;
        for (i = 0; i < nums.size(); i++) {
            XOR = XOR ^ i ^ nums[i];
        }
        return XOR ^ i;
    }
};