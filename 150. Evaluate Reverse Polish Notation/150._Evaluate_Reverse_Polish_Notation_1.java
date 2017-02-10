public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> ops = new ArrayList<String>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        Stack<String> pipe = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (ops.contains(tokens[i])) {
                String a = pipe.pop();
                String b = pipe.pop();
                pipe.push(getAnswer(b, a, tokens[i]));
            } else {
                pipe.push(tokens[i]);
            }
        }
        return Integer.parseInt(pipe.pop());
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