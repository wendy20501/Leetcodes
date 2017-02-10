public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        int start = 0;
        int end = t.length() - 1;
        char first = s.charAt(left);
        char last = s.charAt(right);
        while (start <= end) {
            if (t.charAt(start) == first) {
                //System.out.println("first find : " + first + " at " + start);
                left++;
                if (left > s.length() - 1) {
                    return true;
                }
                first = s.charAt(left);
            }
            if (t.charAt(end) == last) {
                //System.out.println("end find : " + last + " at " + end);
                right--;
                if (right < 0) {
                    return true;
                }
                last = s.charAt(right);
            }
            if (left > right) {
                return true;
            }
            start++;
            end--;
        }
        return false;
    }
}