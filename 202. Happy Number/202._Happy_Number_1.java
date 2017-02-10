public class Solution {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        List<Integer> history = new ArrayList<Integer>();
        while (!history.contains(n)) {
            history.add(n);
            n = getNewNumber(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    
    private int getNewNumber(int n) {
        int new_n = 0;
        while (n / 10 > 0) {
            int bit = n % 10;
            new_n += Math.pow(bit, 2);
            n /= 10;
        }
        new_n += Math.pow(n, 2);
        return new_n;
    }
}