class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> opt(n);
        opt[0] = 1;
        int two = 0, three = 0, five = 0;
        for (int i = 1; i < n; i++) {
            int temp1 = opt[two] * 2;
            int temp2 = opt[three] * 3;
            int temp3 = opt[five] * 5;
            opt[i] = min(temp1, min(temp2, temp3));
            if (opt[i] == temp1)
                two++;
            if (opt[i] == temp2)
                three++;
            if (opt[i] == temp3)
                five++;
        }
        return opt[n-1];
    }
};