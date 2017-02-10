public class Solution {
    public int reverse(int x) {
        String number = String.valueOf(x);
        //System.out.println(number);
        boolean ifNegative = (number.charAt(0) == '-')? true : false;
        
        char[] chars = new char[ifNegative? number.length() - 1 : number.length()];
        //System.out.println(number.length());
        for(int i = 0; i < number.length(); i++) {
            if(ifNegative && i == number.length() - 1) {
                break;
            }
            chars[i] = number.charAt(number.length() - i - 1);
        }
        
        int res;
        try{
            res = Integer.parseInt(new String(chars));
            if(ifNegative) {
              res = 0 - res;
            }
        } catch(Exception e) {
            res = 0;
        }
        
        return res;
    }
}