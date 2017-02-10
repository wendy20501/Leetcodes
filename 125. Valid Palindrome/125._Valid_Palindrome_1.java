public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)) && left < right) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}