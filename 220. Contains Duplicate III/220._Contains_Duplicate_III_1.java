public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1)
            return false;
        Map<Long,Long> mymap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("i = " + i);
            long remapnum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remapnum / ((long)t + 1);
            if (mymap.containsKey(bucket) ||
                (mymap.containsKey(bucket + 1) && Math.abs(mymap.get(bucket + 1) - remapnum) <= t) ||
                (mymap.containsKey(bucket - 1) && Math.abs(mymap.get(bucket - 1) - remapnum) <= t))
                return true;
            if (mymap.size() >= k) {
                long removeBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                //System.out.println("remove " + removeBucket);
                mymap.remove(removeBucket);
            }
            mymap.put(bucket, remapnum);
            //System.out.println("put " + bucket);
        }
        return false;
    }
}