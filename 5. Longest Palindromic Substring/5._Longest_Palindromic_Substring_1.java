public class Solution {
    public String longestPalindrome(String s) {
        int count = 0;
        int MaxCount = 0;
        int Max = 0;
        int fr, be;
        for(int i = 0; i < s.length(); i++) {
            count = 1;
            fr = i - 1;
            be = i + 1;
            while(fr > -1 && be < s.length()) {
                if (s.charAt(fr) == s.charAt(be)) {
                    count += 2;
                } else {
                    break;
                }
                fr -= 1;
                be += 1;
            }
            if (count > MaxCount) {
                MaxCount = count;
                Max = i * 2;
            }
            //System.out.println(count);
            count = 0;
            fr = i;
            be = i + 1;
            while(fr > -1 && be < s.length()) {
                if (s.charAt(fr) == s.charAt(be)) {
                    count += 2;
                } else {
                    break;
                }
                fr -= 1;
                be += 1;
            }
            if (count > MaxCount) {
                MaxCount = count;
                Max = i * 2 + 1;
            }
            //System.out.println(count);
        }
        int start;
        int end;
        if (Max % 2 == 0) {
            start = Max / 2 - (MaxCount - 1) / 2;
            end = Max / 2 + (MaxCount - 1) / 2 + 1;
        } else {
            start = (Max - 1) / 2 - MaxCount / 2 + 1;
            end = ( Max - 1) / 2 + MaxCount / 2 + 1;
        }
        //System.out.println(start);
        //System.out.println(end);
        return s.substring(start, end);
    }
}