public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        int[] newNums = mySort(nums, 0, nums.length - 1);
        for (int i = 0; i < newNums.length; i++) {
            if (start) {
                if (newNums[i] != 0) {
                    sb.append(newNums[i]);
                    start = false;
                }
            } else {
                sb.append(newNums[i]);
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }
    
    private int[] mySort(int[] nums, int start, int end) {
        //System.out.println("mySort(" + start + ", " + end +")");
        int[] result = new int[end - start + 1];
        if (start == end) {
            result[0] = nums[start];
            return result;
        }
        int middle = (start + end) / 2;
        int[] left = mySort(nums, start, middle);
        int[] right = mySort(nums, middle + 1, end);
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if (l >= left.length) {
                result[i] = right[r];
                r++;
            } else if (r >= right.length) {
                result[i] = left[l];
                l++;
            } else if (ifLarger(String.valueOf(left[l]), String.valueOf(right[r]))) {
                result[i] = left[l];
                l++;
            } else {
                result[i] = right[r];
                r++;
            }
            //System.out.println(result[i]);
        }
        
        return result;
    }
    
    private boolean ifLarger(String str1, String str2) {
        if (str1.length() == 0) {
            return false;
        }
        if (str2.length() == 0) {
            return true;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (i == str2.length()) {
                //System.out.println("str1 = " + str1 + " str2 = " + str2 + " str2 end");
                return ifLarger(str1.substring(i), str2)? true : false;
            }
            int ch1 = Character.getNumericValue(str1.charAt(i));
            int ch2 = Character.getNumericValue(str2.charAt(i));
            if (ch1 > ch2) {
                //System.out.println(str1 + " > " + str2);
                return true;
            } else if (ch1 < ch2) {
                //System.out.println(str1 + " < " + str2);
                return false;
            }
        }
        return ifLarger(str1, str2.substring(str1.length()))? true : false;
    }
}