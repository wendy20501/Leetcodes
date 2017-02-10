public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'M') {
                res += 1000;
            } else if (current == 'D') {
                res += 500;
            } else if (current == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                        res += 900;
                        i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                        res += 400;
                        i++;
                } else {
                    res += 100;
                }
            } else if (current == 'L') {
                res += 50;
            } else if (current == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i++;
                } else {
                    res += 10;
                }
            } else if (current == 'V') {
                res += 5;
            } else if (current == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i++;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }
}