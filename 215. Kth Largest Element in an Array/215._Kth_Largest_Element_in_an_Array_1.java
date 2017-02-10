public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> myqueue = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            myqueue.offer(nums[i]);
        }
        
        for (int j = k; j < nums.length; j++) {
            if (nums[j] > myqueue.peek()) {
                myqueue.poll();
                myqueue.offer(nums[j]);
            }
        }
        return myqueue.peek();
    }
}