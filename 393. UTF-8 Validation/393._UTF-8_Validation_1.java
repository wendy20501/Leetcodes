public class Solution {
    public boolean validUtf8(int[] data) {
        String[] UTF8 = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            UTF8[i] = Integer.toBinaryString(data[i]);
            //System.out.println("UTF8[i] = " + UTF8[i]);
        }
        for (int j = 0; j < UTF8.length; j++) {
            String current = UTF8[j];
            if (current.length() == 8) {
                int count = 1;
                while (current.charAt(count) == '1') {
                    count++;
                    if (count > 4) {
                        return false;
                    }
                }
                if (count == 1) {
                    return false;
                } else {
                    for (int k = 1; k < count; k++) {
                        //System.out.println("UTF8[j + k] = " + UTF8[j + k]);
                        if (j + k >= UTF8.length || UTF8[j + k].length() < 8 || !UTF8[j + k].startsWith("10")) {
                            return false;
                        }
                    }
                    j += (count - 1);
                }
            }
        }
        return true;
    }
}