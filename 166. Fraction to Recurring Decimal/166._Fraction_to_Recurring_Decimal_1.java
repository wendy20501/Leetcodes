public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean ifNegative;
        if ((numerator >= 0 && denominator >= 0) || (numerator < 0 && denominator < 0)) {
            ifNegative = false;
        } else {
            ifNegative = true;
        }
        long my_numerator = numerator;
        long my_denominator = denominator;
        my_numerator = Math.abs(my_numerator);
        my_denominator = Math.abs(my_denominator);
        //System.out.println("my_numerator = " + my_numerator);
        //System.out.println("my_denominator = " + my_denominator);
        long quotient = my_numerator / my_denominator;
        long remainder = my_numerator % my_denominator;
        StringBuilder sb = new StringBuilder();
        if (ifNegative) {
            sb.append("-");
        }
        sb.append(quotient);
        if (remainder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
            int size = sb.length();
            List<Long> remainders = new ArrayList<Long>();
            while (remainder != 0) {
                //System.out.println("remainder = " + remainder);
                quotient = (remainder * 10) / my_denominator;
                remainder = (remainder * 10) % my_denominator;
                if (remainders.contains(remainder)) {
                    int pos = size + remainders.indexOf(remainder);
                    if (Character.getNumericValue(sb.charAt(pos)) == quotient) {
                        sb.insert(pos, "(");
                        sb.append(")");
                    } else {
                        sb.insert(pos + 1, "(");
                        sb.append(quotient);
                        sb.append(")");
                    }
                    break;
                }
                remainders.add(remainder);
                //System.out.println("quotient = " + quotient);
                sb.append(quotient);
            }
            return sb.toString();
        }
    }
}