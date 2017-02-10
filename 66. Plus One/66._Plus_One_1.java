public class Solution {
    public int[] plusOne(int[] digits) {
        int count = digits.length - 1;
        if (digits[count] < 9) {
            digits[count] += 1;
            return digits;
        } else {
            digits[count] = 0;
            for (int i = count - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 1; j < result.length; j++) {
                result[j] = digits[j - 1];
            }
            return result;
        }
    }
}