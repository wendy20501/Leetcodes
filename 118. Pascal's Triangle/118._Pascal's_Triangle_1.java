public class Solution {
    public List<List<Integer>> generate(int numRows) {
        return getNext(numRows, new ArrayList<List<Integer>>());
    }
    
    private List<List<Integer>> getNext(int numRows, List<List<Integer>> current) {
        if (numRows == 0) {
            return current;
        }
        if (current.size() == 0) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            current.add(newList);
        } else {
            List<Integer> last = current.get(current.size() - 1);
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            for (int i = 0; i < last.size() - 1; i++) {
                newList.add(last.get(i) + last.get(i + 1));
            }
            newList.add(1);
            current.add(newList);
        }
        return getNext(numRows - 1, current);
    }
}