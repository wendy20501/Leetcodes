public class Solution {
    public int countPrimes(int n) {
        boolean[] ifPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            ifPrime[i] = true;
        }
        
        for (int i = 2; i * i < n; i++) {
            if (ifPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    ifPrime[j] = false;
                }   
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (ifPrime[i])
                count++;
        }
        return count;
    }
    /*
    private boolean isPrime(int n) {
        if (n <= 1) 
            return false;
            
        for (int i = 2; i * i <= n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }*/
}