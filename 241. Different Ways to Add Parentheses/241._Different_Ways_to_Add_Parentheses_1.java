public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0)
            return result;
            
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int ans = 0;
            if ( current == '+' || current == '-' || current == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                for (int i1 : res1) {
                    for (int i2 : res2) {
                        switch(current) {
                            case '+':
                                ans = i1 + i2;
                                break;
                            case '-':
                                ans = i1 - i2;
                                break;
                            case '*':
                                ans = i1 * i2;
                                break;
                        }
                        result.add(ans);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}