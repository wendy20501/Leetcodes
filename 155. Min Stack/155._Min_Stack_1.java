public class MinStack {
    private Stack<Integer> min;
    private Stack<Integer> value;
    
    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack();
        value = new Stack();
    }
    
    public void push(int x) {
        if (value.empty() || x <= min.peek()) {
            //System.out.println("min push: " + x);
            min.push(x);
        }
        value.push(x);
    }
    
    public void pop() {
        int a = value.peek();
        //System.out.println("value.peek(): " + value.peek() + " min.peek(): " + min.peek());
        if (a == min.peek()) {
            //System.out.println("min pop: " + min.peek());
            min.pop();
        }
        value.pop();
    }
    
    public int top() {
        return value.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */