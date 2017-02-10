public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        if (gas.length == 1) {
            if (cost[0] > gas[0]) {
                return -1;
            }
            return 0;
        }
        int[] remain = new int[gas.length];
        int max = 0;
        int min_val = 0;
        for (int i = 0; i < gas.length; i++) {
            remain[i] = gas[i] - cost[i];
            if (i != 0 && remain[i] - remain[i - 1] > min_val) {
                max = i;
                min_val = remain[i] - remain[i - 1];
            }
            if (i == gas.length - 1 && remain[0] - remain[i] > min_val) {
                max = 0;
                min_val = remain[0] - remain[i];
            }
        }
        int j = max;
        int current = 0;
        do {
            //System.out.println("j = " + j + " current = " + current);
            if (current + remain[j] < 0) {
                return -1;
            }
            current += remain[j];
            if (j + 1 == gas.length) {
                j = 0;
            } else {
                j++;
            }
        } while (j != max);
        return max;
    }
}