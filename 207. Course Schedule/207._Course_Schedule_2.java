public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mapAdj = new HashMap<Integer, List<Integer>>();
        int numOfPre = prerequisites.length;
        for (int i = 0; i < numOfPre; i++) {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            if (!mapAdj.containsKey(curCourse)) {
                mapAdj.put(curCourse, new ArrayList<Integer>());
            }
            mapAdj.get(curCourse).add(preCourse);
            System.out.println(curCourse + " : " + mapAdj.get(curCourse));
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int j = 0; j < numCourses; j++) {
            if (hasCycle(mapAdj, j, visited, recStack))
                return false;
        }
        return true;
    }
    
    private boolean hasCycle(Map<Integer, List<Integer>> mapAdj, int current, boolean[] visited, boolean[] recStack) {
        visited[current] = true;
        recStack[current] = true;
        if (mapAdj.containsKey(current)) {
            for (int adj : mapAdj.get(current)) {
                if (!visited[adj] && hasCycle(mapAdj, adj, visited, recStack))
                    return true;
                else if (recStack[adj])
                    return true;
            }
        }
        recStack[current] = false;
        return false;
    }
}