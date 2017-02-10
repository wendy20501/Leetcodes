public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        int len = Integer.toString(n).length();
        int num = (int) Math.pow(10, len - 1);
        if (n / num > 1) {
            return (n / num) * countDigitOne(num - 1) + num + countDigitOne(n % num);
        } else {
            return countDigitOne(num - 1) + countDigitOne(n % num) + (n % num) + 1;
        }
    }
}