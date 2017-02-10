public class Solution {
    public boolean isValid(String s) {
        Stack<Character> mystack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch(current) {
                case '(':
                    mystack.push(current);
                    break;
                case '{':
                    mystack.push(current);
                    break;
                case '[':
                    mystack.push(current);
                    break;
                case ')':
                    if (mystack.empty() || mystack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (mystack.empty() || mystack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (mystack.empty() || mystack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (mystack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}