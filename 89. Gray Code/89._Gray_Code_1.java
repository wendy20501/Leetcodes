public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            result.add(0);
            return result;
        }
        List<Integer> base = grayCode(n - 1);
        result.addAll(new ArrayList<Integer>(base));
        int number = (int)Math.pow(2, n - 1);
        for (int i = base.size() - 1; i >= 0 ; i--) {
            //base.get(i) += Math.pow(2, n - 1);
            result.add(base.get(i) + number);
        }
        return result;
    }
}