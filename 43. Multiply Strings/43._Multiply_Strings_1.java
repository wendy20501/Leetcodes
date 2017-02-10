public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }
        
        StringBuilder ans = new StringBuilder();
        ans.append(num1);
        ans.reverse();
        num1 = ans.toString();
        ans.delete(0, ans.length());
        ans.append(num2);
        ans.reverse();
        num2 = ans.toString();
        ans.delete(0, ans.length());
        //System.out.println(num1);
        for (int i = 0; i < num2.length(); i++) {
            int carry = 0;
            for (int j = 0; j < num1.length(); j++) {
                //System.out.println(num2.charAt(i));
                int result = (Character.getNumericValue(num2.charAt(i)) * Character.getNumericValue(num1.charAt(j))) + carry;
                if (i == 0 || ans.length() <= j + i) {
                    ans.append(result % 10);
                    //System.out.println("1: " + result % 10);
                    carry = result / 10;
                    if (j == num1.length() - 1 && carry != 0) {
                        ans.append(carry);
                        //System.out.println("2: " + carry);
                    }
                } else {
                    //System.out.println("result_org = " + result);
                    //System.out.println("current = " + Character.getNumericValue(ans.charAt(j + i)));
                    result = Character.getNumericValue(ans.charAt(j + i)) + result;
                    ans.deleteCharAt(j + i);
                    ans.insert(j + i, result % 10);
                    //ans.setCharAt(j + i, Character.toChars(result % 10));
                    //System.out.println("result = " + result);
                    //System.out.println("3: ans[" + (j + i) + "] = " + result % 10);
                    carry = result / 10;
                    if (j == num1.length() - 1 && carry != 0) {
                        ans.append(carry);
                        //System.out.println("4: " + carry);
                    }
                }
            }
        }
        ans.reverse();
        return ans.toString();
    }
}