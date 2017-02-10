public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int result = 0;
        int num;
        for (int i = 0; i < A.length; i++) {
            result = 0;
            num = i;
            for (int j = 0; j < A.length; j++) {
                //System.out.println("num = " + num);
                result += A[j] * num;
                num++;
                if (num == A.length) {
                    num = 0;
                }
            }
            //System.out.println(result);
            if (result > max) {
                max = result;
            }
        }
        return max;
    }
}