public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() == 1) {
                    return i;
                }
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}