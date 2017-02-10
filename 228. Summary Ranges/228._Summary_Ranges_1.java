public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0)
            return result;
        int start = nums[0];
        int current = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current + 1)
                current = nums[i];
            else {
                String ans = start == current ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(current);
                result.add(ans);
                start = nums[i];
                current = start;
            }
        }
        String ans = start == current ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(current);
        result.add(ans);
        return result;
    }
}