public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            letters[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            int num = ransomNote.charAt(j) - 'a';
            if (letters[num] == 0) {
                return false;
            } else {
                letters[num]--;
            }
        }
        return true;
    }
}