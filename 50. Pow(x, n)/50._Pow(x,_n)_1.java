public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean ifNegativePow = false;
        if (n < 0) {
            n = 0 - n;
            ifNegativePow = true;
        }
        boolean ifNegative = false;
        if (x < 0) {
            x = 0 - x;
            if (n % 2 != 0) {
                ifNegative = true;
            }
        }
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return ifNegative? -1 : 1;
        } 
        double ans = x; 
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(Double.MAX_VALUE, ans * x);
            if (ans == Double.MAX_VALUE) {
                break;
            }
            if (ans == 0) {
                break;
            }
        }
        if (ifNegativePow) {
            if (ans == Double.MAX_VALUE) {
                return 0;
            } else if (ans == 0) {
                ans = Double.POSITIVE_INFINITY;
            } else {
                ans = 1 / ans;
            }
        }
        if (ifNegative) {
            if (ans == Double.MAX_VALUE) {
                ans = Double.MIN_VALUE;
            } else if (ans == Double.POSITIVE_INFINITY) {
                ans = Double.NEGATIVE_INFINITY;
            } else {
                ans = 0 - ans;
            }
        }
        return ans;
    }
}