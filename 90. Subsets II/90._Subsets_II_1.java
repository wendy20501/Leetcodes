public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        //int current = nums[0];
        //int sameCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
           // if (i == 0 || current != nums[i]) {
                //sameCnt = 0;
                for (int j = 0; j < size; j++) {
                    List<Integer> temp = new ArrayList<Integer>(result.get(j));
                    temp.add(nums[i]);
                    if (!result.contains(temp)) {
                        result.add(temp);
                    }
                }
            /*} else {
                sameCnt++;
                for (int j = size / (int)Math.pow(2, sameCnt); j < size; j++) {
                    List<Integer> temp = new ArrayList<Integer>(result.get(j));
                    temp.add(nums[i]);
                    result.add(temp);
                }
            }
            current = nums[i];*/
        }
        return result;
    }
}