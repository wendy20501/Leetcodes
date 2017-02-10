public class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2 + 1;
        while (left <= right) {
            //System.out.println("left = " + left);
            //System.out.println("right = " + right);
            int mid = left + (right - left) / 2;
            //System.out.println("mid = " + mid);
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return (left + right) / 2;
    }
}