public class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
    		return "";
    	}
        int a = 0;
        int b = 0;
        int[] count = new int[10]; 
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a += 1;
            } else {
            	count[secret.charAt(i) - '0']++;
                if (count[secret.charAt(i) - '0'] <= 0) {
                	b++;
                }
                count[guess.charAt(i) - '0']--;
                if (count[guess.charAt(i) - '0'] >= 0) {
                	b++;
                }
            }
        }
        return Integer.toString(a) + "A" + Integer.toString(b) + "B";
    }
}