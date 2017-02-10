public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        List<Character> sub = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (sub.contains(current)) {
                max = Math.max(max, sub.size());
                while(sub.contains(current)) {
                    sub.remove(start);
                }
            }
            sub.add(current);
        }
        return Math.max(max, sub.size());
    }
}