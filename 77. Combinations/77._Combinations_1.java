public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == k) {
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                ans.add(i);
            }
            result.add(ans);
            return result;
        } else if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(i);
                result.add(ans);
            }
            return result;
        } else {
            List<List<Integer>> child1 = combine(n - 1, k - 1);
            List<List<Integer>> child2 = combine(n - 1, k);
            for (int i = 0; i < child1.size(); i++) {
                child1.get(i).add(n);
            }
            result.addAll(child1);
            result.addAll(child2);
        }
        return result;
    }
}