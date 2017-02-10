public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0)
            return null;
        return combination(k, n, 10);
    }
    
    private List<List<Integer>> combination(int k, int target, int end) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 1 && target < end) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(target);
            result.add(ans);
        } else {
            for (int i = 1; i < end && target - i > 0; i++) {
                List<List<Integer>> subans = combination(k - 1, target - i, i);
                for (int j = 0; j < subans.size(); j++) {
                    subans.get(j).add(i);
                }
                result.addAll(subans);
            }
        }
        return result;
    }
}