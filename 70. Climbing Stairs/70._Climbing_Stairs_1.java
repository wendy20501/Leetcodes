public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        } else {
            int[] ways = new int[n + 1];
            ways[0] = 1;
            for (int i = 0; i < n + 1; i++) {
                if (i + 1 < n + 1) {
                    ways[i + 1] += ways[i];
                } 
                if (i + 2 < n + 1) {
                    ways[i + 2] += ways[i];
                }
                //System.out.println("ways[" + i + "] = " + ways[i]);
            }
            return ways[n];
        }
    }
}