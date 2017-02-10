public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] ayAdj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ayAdj[i] = new ArrayList();
        }
        int numOfPre = prerequisites.length;
        for (int i = 0; i < numOfPre; i++) {
            ayAdj[prerequisites[i][1]].add(prerequisites[i][0]);
            //System.out.println(curCourse + " : " + mapAdj.get(curCourse));
        }
        boolean[] visited = new boolean[numCourses];
        for (int j = 0; j < numCourses; j++) {
            if (!dfs(ayAdj, j, visited))
                return false;
        }
        return true;
    }
    
    private boolean dfs(ArrayList[] ayAdj, int current, boolean[] visited) {
        if (visited[current]) 
            return false;
        else
            visited[current] = true;
        
        for (int i = 0; i < ayAdj[current].size(); i++) {
            if (!dfs(ayAdj, (int)ayAdj[current].get(i), visited))
                return false;
        }
        visited[current] = false;
        return true;
    }
}