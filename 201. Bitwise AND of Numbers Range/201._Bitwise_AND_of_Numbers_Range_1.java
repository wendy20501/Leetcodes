public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        String str_m = Integer.toBinaryString(m);
        //System.out.println("m =" + str_m);
        String str_n = Integer.toBinaryString(n);
        //System.out.println("n =" + str_n);
        if (str_m.length() != str_n.length()) {
            return 0;
        }
        for (int i = 0; i < str_m.length(); i++) {
            if (str_m.charAt(i) != str_n.charAt(i)) {
                //System.out.println("i =" + i);
                m = m >> (str_m.length() - i);
                m = m << (str_m.length() - i);
                return m;
            }
        }
        return 0;
    }
}