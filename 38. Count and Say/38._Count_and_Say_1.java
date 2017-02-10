public class Solution {
    public String countAndSay(int n) {
        String init = "1";
        if (n == 1) {
            return init;
        }
        String ans = getSequence(init);
        for (int i = 0; i < n - 2; i++) {
            ans = getSequence(ans);
        }
        return ans;
    }
    
    private String getSequence(String input) {
        int count = 1;
        char current = input.charAt(0);
        String ans = "";
        //System.out.println(input + " length = " + input.length());
        if (input.length() == 1) {
            ans = String.valueOf(count) + input.charAt(0);
            return ans;
        }
        for (int i = 1; i < input.length(); i++) {
            if (current == input.charAt(i)) {
                count++;
            } else {
                ans = ans + String.valueOf(count) + current;
                current = input.charAt(i);
                count = 1;
            }
            if (i == input.length() - 1) {
                ans = ans + String.valueOf(count) + input.charAt(i);
            }
        }
        return ans;
    }
}