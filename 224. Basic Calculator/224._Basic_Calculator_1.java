public class Solution {
    public int calculate(String s) {
        int result = 0; //record the current result
        Stack<Integer> mystack = new Stack<Integer>();
        int number = 0; //record current number
        int sign = 1; //record the last sign
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (int)(ch - '0');
            } else {
                switch(ch) {
                    case '+':
                        result += sign * number;  //finish the previous calculate
                        sign = 1; //assign sign to 1 (positive)
                        number = 0;
                        break;
                    case '-':
                        result += sign * number;
                        sign = -1; //assign sign to -1 (negative)
                        number = 0;
                        break;
                    case '(':
                        mystack.push(result); //record current sign and result
                        mystack.push(sign);
                        result = 0; //reset all
                        sign = 1;
                        break;
                    case ')':
                        result += sign * number; //finish the previous calculate
                        number = 0;
                        result *= mystack.pop(); //finish the previous calculate in stack
                        result += mystack.pop();
                        break;
                }
            }
        }
        return result += sign * number; //finish the previous calculate
    }

}