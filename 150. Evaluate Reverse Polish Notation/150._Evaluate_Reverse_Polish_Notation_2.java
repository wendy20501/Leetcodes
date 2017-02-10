public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> ops = new ArrayList<String>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        boolean[] ifUsed = new boolean[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            if (ops.contains(tokens[i])) {
                int j = i - 1;
                while (ifUsed[j]) {
                    j--;
                }
                int k = j - 1;
                while (ifUsed[k]) {
                    k--;
                }
                ifUsed[j] = true;
                ifUsed[k] = true;
                tokens[i] = getAnswer(tokens[k], tokens[j], tokens[i]);
            }
        }
        return Integer.parseInt(tokens[tokens.length - 1]);
    }
    
    private String getAnswer(String a, String b, String op) {
        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);
        int ans = 0;
        switch(op) {
            case "+":
                ans = n1 + n2;
                break;
            case "-":
                ans = n1 - n2;
                break;
            case "*":
                ans = n1 * n2;
                break;
            case "/":
                ans = n1 / n2;
                break;
        }
        //System.out.print(a + op + b +" = " + ans);
        return Integer.toString(ans);
    }
}