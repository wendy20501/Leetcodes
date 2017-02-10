public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] ayAdj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ayAdj[i] = new ArrayList();
        }
        int[] linkCount = new int[numCourses];
        for (int[] edge : prerequisites) {
            if (!ayAdj[edge[1]].contains(edge[0])) {
                ayAdj[edge[1]].add(edge[0]);
                linkCount[edge[0]]++;
            }
        }
        
        Queue<Integer> open = new LinkedList<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (linkCount[i] == 0)
                open.offer(i);
        }
        
        int[] ans = new int[numCourses];
        int count = 0;
        while (open.size() != 0) {
            int current = open.poll();
            ans[count++] = current;
            for (int i = 0; i < ayAdj[current].size(); i++) {
                int adj = (int)ayAdj[current].get(i);
                linkCount[adj]--;
                if (linkCount[adj] == 0)
                    open.offer(adj);
            }
        }
       
        return count == numCourses ? ans : new int[0];
    }
}