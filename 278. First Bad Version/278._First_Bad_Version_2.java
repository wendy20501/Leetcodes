/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return findFirstBadVersion(1, n);
    }
    
    private int findFirstBadVersion(int start, int end) {
        if (start >= end)
            return start;
        int mid = start + ((end - start) / 2); 
        if (isBadVersion(mid))
            return findFirstBadVersion(start, mid);
        return findFirstBadVersion(mid + 1, end);
    }
}