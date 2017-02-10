public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, current, result);
        return result;
    }
    
    private void findCombination(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0 && !result.contains(current)) {
            List<Integer> temp = new ArrayList<Integer>(current);
            result.add(temp);
            //System.out.println("add: " + current);
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                //System.out.println("1: " + i);
                return;
            }
            /*
            if (current.isEmpty()) {
                while (i > 0 && candidates[i] == candidates[i - 1]) {
                    if (i != candidates.length - 1) {
                        System.out.println("2: " + i);
                        i += 1;
                    } else {
                        current.add(candidates[i]);
                        return;
                    }
                }
            }*/
            current.add(candidates[i]);
            //System.out.println("in: " + current);
            findCombination(candidates, target - candidates[i], i + 1, current, result);
            //System.out.println("out: " + current);
            current.remove(current.size() - 1);
            //System.out.println("end: " + current);
        }
        return;
    }
}