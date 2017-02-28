public class Solution {
    public int nthUglyNumber(int n) {
        int[] opt = new int[n];
        opt[0] = 1;
        int two = 0, three= 0, five = 0;
        for (int i = 1; i < n; i++) {
            int temp1 = opt[two] * 2;
            int temp2 = opt[three] * 3;
            int temp3 = opt[five] * 5;
            opt[i] = Math.min(temp1, temp2);
            opt[i] = Math.min(opt[i], temp3);
            if (opt[i] == temp1)
                two++;
            else if (opt[i] == temp2)
                three++;
            else
                five++;
            if (opt[i] == opt[i-1])
                i--;
        }
        return opt[n-1];
    }
}