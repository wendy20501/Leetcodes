public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        ArrayList[] ayAdj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ayAdj[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!ayAdj[prerequisites[i][0]].contains(prerequisites[i][1]))
                ayAdj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        int count = 0;
        Queue<Integer> open = new LinkedList<Integer>();
        boolean[] visited  = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (ayAdj[i].size() == 0) {
                open.offer(i);
                visited[i] = true;
            }
        }
        
        while (open.size() != 0) {
            int current = open.poll();
            ans[count] = current;
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (!visited[i] && ayAdj[i].contains(current)) {
                    ayAdj[i].remove(new Integer(current));
                    if (ayAdj[i].size() == 0) {
                        open.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
        if (count != numCourses) {
            ans = new int[]{};
        }
        return ans;
    }
}