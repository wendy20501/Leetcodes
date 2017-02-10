public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        findCombination(candidates, target, 0, current, result);
        return result;
    }
    
    private void findCombination(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>(current);
            result.add(temp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            current.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}