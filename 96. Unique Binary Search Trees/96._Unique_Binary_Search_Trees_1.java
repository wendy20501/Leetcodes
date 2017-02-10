public class Solution {
    public int numTrees(int n) {
       if (n <= 0) {
           return 0;
       }
       int[] BST = new int[n + 1];
       BST[0] = 1;
       for (int j = 1; j <= n; j++) {
           BST[j] = 0;
           for (int i = 1; i <= j; i++) {
               BST[j] += BST[i - 1] * BST[j - i];
           }
           //System.out.println("BST[" + j + "] = " +BST[j]);
       }
       return BST[n];
    }
}