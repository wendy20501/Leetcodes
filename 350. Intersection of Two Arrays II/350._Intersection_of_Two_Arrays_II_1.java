public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length) {
                if (nums1[i] < nums2[j]) 
                    break;
                else if (nums1[i] == nums2[j]) {
                    res.add(nums1[i]);
                    if (j == nums2.length - 1) {
                        int[] ayres = new int[res.size()];
                        int index = 0;
                        for (Integer item : res) {
                            ayres[index] = item.intValue();
                            index++;
                        }
                        return ayres;
                    } else 
                        j++;
                        break;
                }
                j++;
            }
        }
        int[] ayres = new int[res.size()];
        int index = 0;
        for (Integer item : res) {
            ayres[index] = item.intValue();
            index++;
        }
        return ayres;
    }
}