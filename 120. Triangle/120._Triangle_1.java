public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() != 1) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    //System.out.println("triangle[" + i + "][" + j + "] = " + triangle.get(i).get(j));
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
                    //System.out.println("new triangle[" + i + "][" + j + "] = " + triangle.get(i).get(j));
                }
            }
        }
        return triangle.get(0).get(0);
    }
}