public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        boolean[] ifMatch = new boolean[s.length() + 1];
        ifMatch[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (ifMatch[j] && wordDict.contains(s.substring(j, i))) {
                    ifMatch[i] = true;
                }
            }
        }
        return ifMatch[s.length()];
    }
}