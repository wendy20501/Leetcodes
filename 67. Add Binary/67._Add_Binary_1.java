public class Solution {
    public String addBinary(String a, String b) {
        int size = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int sum = carry;
            if (i < a.length()) {
                sum += Character.getNumericValue(a.charAt(a.length() - 1 - i));
            }
            if (i < b.length()) {
                sum += Character.getNumericValue(b.charAt(b.length() - 1 - i));
            }
            carry = sum / 2;
            sum = sum % 2;
            //System.out.println("carry = " + carry);
            //System.out.println("add sum = " + sum);
            result.append(sum);
        }
        if (carry != 0) {
            result.append(carry);
            //System.out.println("add carry = " + carry);
        }
        result.reverse();
        return result.toString();
    }
}