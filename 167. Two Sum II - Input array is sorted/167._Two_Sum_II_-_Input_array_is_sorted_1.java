public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = getTheOther(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (j != -1) {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return null;
    }
    
    private int getTheOther(int[] numbers, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] > target) {
            return getTheOther(numbers, target, start, mid - 1);
        } else {
            return getTheOther(numbers, target, mid + 1, end);
        }
    }
}