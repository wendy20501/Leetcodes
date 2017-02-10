public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        int limit = nums.length / 3;
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (result.contains(current))
                continue;
            if (mymap.containsKey(current))
                mymap.put(current, mymap.get(current)+1);
            else
                mymap.put(current, 1);
            if (mymap.get(current) > limit)
                result.add(current);
        }
        return result;
    }
}