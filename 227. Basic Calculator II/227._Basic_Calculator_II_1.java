public class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        int temp = 1;
        boolean ifDivid = false;
        Stack<Integer> mystack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (int)(ch - '0');
            } else {
                switch(ch) {
                    case '+':
                        result += sign * (ifDivid ? temp / number : temp * number);
                        temp = 1;
                        sign = 1;
                        number = 0;
                        ifDivid = false;
                        break;
                    case '-':
                        result += sign * (ifDivid ? temp / number : temp * number);
                        temp = 1;
                        sign = -1;
                        number = 0;
                        ifDivid = false;
                        break;
                    case '*':
                        temp =  ifDivid ? temp / number : temp * number;
                        number = 0;
                        ifDivid = false;
                        break;
                    case '/':
                        temp = ifDivid ? temp / number : temp * number;
                        number = 0;
                        ifDivid = true;
                        break;
                }
            }
        }
        result += sign * (ifDivid ? temp / number : temp * number);
        return result;
    }
}