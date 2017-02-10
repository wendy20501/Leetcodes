public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if (s.equals("") || words.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                //System.out.println("add:"+ words[i]);
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        if (sb.length() == 0) {
            return "";
        } else {
            return sb.substring(0, sb.length() - 1);
        }
    }
}