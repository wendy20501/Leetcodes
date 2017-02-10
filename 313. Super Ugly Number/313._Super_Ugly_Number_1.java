import java.lang.Math.*;
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int size = primes.length;
        int[] val = new int[n];
        int[] index = new int[size];
        int[] cur = new int[size];
        val[0] = 1;
        for(int i = 0; i < size; i++) {
            index[i] = 0;
            cur[i] = primes[i];
        }
        int min = 0;
        int minindex = 0;
        for(int j = 1; j < n; j++) {
            for (int k = 0; k < size; k++) {
                if (cur[k] == val[j-1]) {
                    index[k] += 1;
                    cur[k] = val[index[k]] * primes[k];
                }
                if (k == 0) {
                    min = cur[k];
                    minindex = k;
                } else if (cur[k] < min) {
                    min = cur[k];
                    minindex = k;
                }
            }
            val[j] = min;
            index[minindex] += 1;
            cur[minindex] = val[index[minindex]] * primes[minindex];
        }
        return val[n-1];
    }
}