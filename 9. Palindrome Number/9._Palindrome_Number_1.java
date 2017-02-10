public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            String str = String.valueOf(x);
            for(int i = 0; i < str.length()/2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}