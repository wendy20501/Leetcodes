public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return decode(s);
    }
    
    private String decode(String s) {
        //StringBuilder sb = new StringBuilder();
        Stack<Integer> count = new Stack<Integer>();
        Stack<String> value = new Stack<String>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isAlphabetic(current)) {
                value.push(Character.toString(current));
            } else if (Character.isDigit(current)) {
                if (cnt == 0) {
                    cnt = Character.getNumericValue(current);
                } else {
                    cnt = cnt * 10 + Character.getNumericValue(current);
                }
            } else if (current == '[') {
                value.push(Character.toString(current));
                count.push(cnt);
                cnt = 0;
            } else if (current == ']') {
                int times = count.pop();
                StringBuilder sb = new StringBuilder();
                String top_value = value.pop();
                while (!top_value.equals("[")) {
                    sb.insert(0, top_value);
                    top_value = value.pop();
                }
                String last_value = sb.toString();
                sb.delete(0, sb.length());
                //System.out.println("times = " + times);
                //System.out.println("last_value = " + last_value);
                for (int j = 0; j < times; j++) {
                    value.push(last_value);
                }
            }
            /*
            System.out.println("cnt = " + cnt);
            if (!value.isEmpty()) {
                System.out.println("value peek = " + value.peek());
            }*/
        }
        StringBuilder sb = new StringBuilder();
        while (!value.isEmpty()) {
            sb.insert(0, value.pop());
        }
        return sb.toString();
    }
}