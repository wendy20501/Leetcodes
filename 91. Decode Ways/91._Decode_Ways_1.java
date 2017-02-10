public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || Character.getNumericValue(s.charAt(0)) == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = 1;
        if (Character.getNumericValue(s.charAt(0)) == 1 || (Character.getNumericValue(s.charAt(0)) == 2 && Character.getNumericValue(s.charAt(1)) < 7)) {
            dp[1]++;
        }
        if (Character.getNumericValue(s.charAt(1)) == 0) {
            dp[1]--;
        }
        for (int i = 2; i < s.length(); i++) {
            dp[i] = dp[i - 1];
            if (Character.getNumericValue(s.charAt(i)) == 0) {
                if (Character.getNumericValue(s.charAt(i - 1)) > 2) {
                    return 0;
                } else {
                    dp[i] = 0;
                }
            }
         //   if (Character.getNumericValue(s.charAt(i - 1)) != 0) {
                if (Character.getNumericValue(s.charAt(i - 1)) == 1 || (Character.getNumericValue(s.charAt(i - 1)) == 2 && Character.getNumericValue(s.charAt(i)) < 7)) {
                    dp[i] += dp[i - 2];
                }
         //   }
        }
        return dp[s.length() - 1];
    }
}