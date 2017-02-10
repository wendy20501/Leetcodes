public class Solution {
    public int compareVersion(String version1, String version2) {
        int index = version1.indexOf(".");
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int size = Math.min(num1.length, num2.length);
        for (int i = 0; i < size; i++) {
            if (Integer.parseInt(num1[i]) > Integer.parseInt(num2[i])) {
                return 1;
            } else if (Integer.parseInt(num1[i]) < Integer.parseInt(num2[i])) {
                return -1;
            }
        }
        if (num1.length > num2.length) {
            for (int i = size; i < num1.length; i++) {
                if (Integer.parseInt(num1[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else if (num1.length < num2.length) {
            for (int i = size; i < num2.length; i++) {
                if (Integer.parseInt(num2[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }
}