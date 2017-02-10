public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        //System.out.println("s = " + s);
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        boolean ifMatch = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (dict.containsKey(current)) {
                dict.put(current, dict.get(current) + 1);
                //System.out.println("put " + current + " " + dict.get(current));
                if (dict.get(current) >= k) {
                    ifMatch = true;
                }
            } else {
                dict.put(current, 1);
            }
        }
        if (ifMatch) {
        //System.out.println("ifMatch = " + ifMatch);
            int start = 0;
            int max = -1;
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                //System.out.println(current + " => " + dict.get(current));
                if (dict.get(current) < k) {
                    if (i - start >= k) {
                        int ans = longestSubstring(s.substring(start, i), k);
                        //System.out.println("ans =" + ans);
                        if (ans > max) {
                            max = ans;
                        }
                    }
                    start = i + 1;
                }
                if (i == s.length() - 1 && start != 0 && i - start >= k) {
                    int ans = longestSubstring(s.substring(start, i + 1), k);
                    //System.out.println("last ans =" + ans);
                    if (ans > max) {
                        max = ans;
                    }
                }
            }
            if (max == -1) {
                return s.length() - start;
            }
            return max;
        }
        return 0;
    }
}