public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!res.contains(nums1[i])) {
                    if (nums1[i] == nums2[j]) {
                        res.add(nums1[i]);
                        break;
                    } else if (nums1[i] < nums2[j])
                        break;
                }
            }
        }
        int[] ayres = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ayres[i] = res.get(i).intValue();
        }
        return ayres;
    }
}