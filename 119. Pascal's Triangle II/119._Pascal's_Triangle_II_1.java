public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 1; i < rowIndex / 2 + 1; i++) {
            result.add(combination(rowIndex, i));
        }
        
        int end = (rowIndex % 2 == 0) ? result.size() - 2 : result.size() - 1;
        for (int j = 0; j <= end; j++) {
            result.add(result.get(end - j));
        }
        
        return result;
    }
    private int combination(int n, int k) {
        long a = 1;
        for (int i = 0; i < k; i++) {
            a = a * (n - i) / (i + 1);
        }
        return (int)a;
    }
    
}