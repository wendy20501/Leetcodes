public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> init = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            init.add(nums[i]);
        }
        result.add(init);
        if (nums.length <= 1) {
            return result;
        } 
        
        
        return getPermute(init);
    }
    
    private List<List<Integer>> getPermute(List<Integer> init) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (init.size() == 1) {
            result.add(init);
            return result;
        }
        
        for (int i = 0; i < init.size(); i++) {
            int first = init.get(0);
            init.remove(0);
            List<List<Integer>> temp = getPermute(init);
            for (int j = 0; j < temp.size(); j++) {
                List<Integer> ans = temp.get(j);
                for (int k = 0; k < ans.size(); k++) {
                    ans.add(k, first);
                    List<Integer> fullans = new ArrayList<Integer>(ans);
                    result.add(fullans);
                    ans.remove(k);
                }
                ans.add(first);
                List<Integer> fullans = new ArrayList<Integer>(ans);
                result.add(fullans);
                ans.remove(ans.size() - 1);
            }
        }
        return result;
    }
}