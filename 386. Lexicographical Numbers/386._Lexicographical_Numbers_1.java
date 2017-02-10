public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        getElementsStartsFrom(1, n, result);
        return result;
    }
    
    private void getElementsStartsFrom(int start, int n, List<Integer> dic) {
        dic.add(start);
        if (start * 10 <= n) {
            getElementsStartsFrom(start * 10, n, dic);
        }
        if (start < n && start % 10 < 9) {
            getElementsStartsFrom(start + 1, n, dic);
        }
    }
}