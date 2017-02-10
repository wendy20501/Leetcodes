public class Solution {
    public int trailingZeroes(int n) {
        int ans = n / 5;
        int result = 0;
        while (ans > 0) {
            result += ans;
            ans = ans / 5;
        }
        return result;
    }
}