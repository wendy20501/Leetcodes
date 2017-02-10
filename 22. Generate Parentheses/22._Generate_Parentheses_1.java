public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        } else if (n == 1) {
            String ans = "()";
            res.add(ans);
            return res;
        } else {
            List<String> temp = generateParenthesis(n - 1);
            for (int i = 0; i < temp.size(); i++) {
                String base = temp.get(i);
                for (int j = 0; j < base.length(); j++) {
                    String ans = base.substring(0, j) + "()" + base.substring(j);
                    if (!res.contains(ans)) {
                        res.add(ans);
                    }
                }
            }
        }
        return res;
    }
}