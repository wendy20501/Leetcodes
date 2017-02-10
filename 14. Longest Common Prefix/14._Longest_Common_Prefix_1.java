public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        char current;
        if (strs.length < 1) {
            return prefix;
        } else if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            current = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != current) {
                    return prefix;
                } 
                if (j == strs.length - 1) {
                    prefix += current;
                }
            }
        }
        return prefix;
    }
}