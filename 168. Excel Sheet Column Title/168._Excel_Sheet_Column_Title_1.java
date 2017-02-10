public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return null;
        }
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        int quotient = (n - 1) / 26;
        int remainder = (n - 1) % 26;
        //System.out.println("quotient = " + quotient);
        //System.out.println("remainder = " + remainder);
        sb.append(alphabet[remainder]);
        while (quotient > 0) {
            quotient -= 1;
            remainder = quotient % 26;
            quotient = quotient / 26;
            //System.out.println("quotient = " + quotient);
            //System.out.println("remainder = " + remainder);
            sb.append(alphabet[remainder]);
        }
        sb.reverse();
        return sb.toString();
    }
}