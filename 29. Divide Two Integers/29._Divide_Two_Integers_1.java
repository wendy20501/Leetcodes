public class Solution {
    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MAX_VALUE && divisor == -1) || (dividend == Integer.MIN_VALUE && divisor == -1) ||divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return 0 - dividend;
        }
        boolean ifnegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        System.out.println(ifnegative);
        long a = dividend;
        a = (a < 0)? 0 - a : a;
        long b = divisor;
        b = (b < 0)? 0 - b : b;
       
        //System.out.println(a);
        //System.out.println(b);
        
        int ans = 0;
        for (int i = 0; i < a; i++) {
            long res = a - (b << i);
            //System.out.println("res: " + res);
            if (res == 0) {
                ans += 1 << i;
                break;
            } else if (res < 0) {
                if (i != 0) {
                    ans += 1 << (i - 1);
                    a = a - (b << (i - 1));
                    i = -1;
                    //System.out.println("a: " + a);
                } else {
                    if (ifnegative) {
                        ans = 0 - ans;
                    }
                    return ans;
                }
            }
            //System.out.println("ans: " + ans);
        }
        //System.out.println("ans: " + ans);
        if (ifnegative) {
            ans = 0 - ans;
        }
        return ans;
    }
}