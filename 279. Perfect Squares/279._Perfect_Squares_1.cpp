class Solution {
public:
    int numSquares(int n) {
        vector<int> dp({0});
        while(dp.size() <= n) {
            int m = dp.size();
            int min = INT_MAX;
            for (int i = 1; i*i <= m; i++) {
                if (dp[m - i * i] + 1 < min)
                    min = dp[m - i * i] + 1;
            }
            dp.push_back(min);
        }
        return dp[n];
    }
};