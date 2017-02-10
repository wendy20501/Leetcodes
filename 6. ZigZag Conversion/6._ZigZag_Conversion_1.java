public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        int distence = 2 * numRows - 2;
        int current = 0;
        char[] chars = new char[s.length()];
        int count = 0;
        for(int i = 0; i < numRows; i++) {
            current = i;
            chars[count] = s.charAt(current);
            int next1 = distence - 2 * i;
            //System.out.println(next1);
            int next2 = distence - next1;
            //System.out.println(next2);
            while(current + next1 < s.length()) {
                if (next1 != 0) {
                    count += 1;
                    current += next1;
                    chars[count] = s.charAt(current);
                }
                if (next2 != 0) {
                    if (current + next2 < s.length()) {
                        count += 1;
                        current += next2;
                        chars[count] = s.charAt(current);
                    } else {
                        break;
                    }
                }
            }
            count++;
        }
        return String.valueOf(chars);
    }
}