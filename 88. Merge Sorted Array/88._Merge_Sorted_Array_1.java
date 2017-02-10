public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current = n + m - 1;
        int n1, n2;
        while (current >= 0) {
            if (m - 1 >= 0) {
                n1 = nums1[m - 1];
            } else {
                n1 = Integer.MIN_VALUE;
            }
            if (n - 1 >= 0) {
                n2 = nums2[n - 1];
            } else {
                n2 = Integer.MIN_VALUE;
            }
            if (n1 >= n2) {
                nums1[current] = n1;
                m--;
            } else {
                nums1[current] = n2;
                n--;
            }
            current--;
        }
    }
}