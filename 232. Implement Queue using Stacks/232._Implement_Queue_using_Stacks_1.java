public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (st1.isEmpty()) {
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            st2.push(x);
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        } else {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(x);
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (st1.isEmpty())
            return st2.pop();
        else
            return st1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (st1.isEmpty())
            return st2.peek();
        else
            return st1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (st1.isEmpty() && st2.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */