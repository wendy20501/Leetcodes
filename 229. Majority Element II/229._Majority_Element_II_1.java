public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) { //majority vote algorithm
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        //System.out.println("candidate1="+candidate1);
        //System.out.println("candidate2="+candidate2);
        count1 = 0;
        count2 = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == candidate1)
                count1++;
            else if (nums[j] == candidate2)
                count2++;
        }
        //System.out.println("count1="+count1);
        //System.out.println("count2="+count2);
        if (count1 > nums.length / 3)
            result.add(candidate1);
        if (count2 > nums.length / 3)
            result.add(candidate2);
        return result;
    }
}