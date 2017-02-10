public class Solution {
    public char findTheDifference(String s, String t) {
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }
        char current = t.charAt(0);
        for (int j = 0; j < t.length(); j++) {
            current = t.charAt(j);
            if (alphabets[current - 'a'] == 0) {
                return current;
            } else {
                alphabets[current - 'a']--;
            }
        }
        return current;
    }
}