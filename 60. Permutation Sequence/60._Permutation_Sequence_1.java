public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> digit = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            digit.add(i);
        }
        int[] permutation = new int[n + 1];
        permutation[0] = 1;
        for (int i = 1; i < n; i++) {
            permutation[i] = permutation[i - 1] * i;
        }
        
        StringBuilder result = new StringBuilder();
        
        int round = n - 1;
        while (round >= 0) {
            result.append(digit.remove(k / permutation[round]));
            k %= permutation[round];
            round--;
        }

        return result.toString();
    }
}