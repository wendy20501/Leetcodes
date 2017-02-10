/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> mystack = new Stack<NestedInteger>();
        NestedInteger result = new NestedInteger();
        if (!s.contains("[")) {
            result.setInteger(Integer.parseInt(s));
            return result;
        }
        int Integer_start = -1;
        mystack.push(result);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '[') {
                NestedInteger newNode = new NestedInteger();
                mystack.peek().add(newNode);
                mystack.push(newNode);
            } else if (current == ']') {
                if (Integer_start != -1) {
                    mystack.peek().add(new NestedInteger(Integer.parseInt(s.substring(Integer_start, i))));
                    Integer_start = -1;
                }
                mystack.pop();
            } else if (current == ',') {
                if (Integer_start != -1) {
                    mystack.peek().add(new NestedInteger(Integer.parseInt(s.substring(Integer_start, i))));
                    Integer_start = -1;
                }
            } else {
                if (Integer_start == -1) {
                    Integer_start = i;
                }
            }
        }
        return result;
    }
}