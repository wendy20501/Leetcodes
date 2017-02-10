public class Solution {
    public int maxProduct(String[] words) {
        int size = words.length;
        int[] ch = new int[size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                ch[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((ch[i] & ch[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}