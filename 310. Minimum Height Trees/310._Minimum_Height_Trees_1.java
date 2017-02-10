public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> nodes = new HashMap<Integer, List<Integer>>();
    	int[] neighbors = new int[n];
        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList());
            neighbors[i] = 0;
        }
        
        for (int j = 0; j < edges.length; j++) {
            nodes.get(edges[j][0]).add(edges[j][1]);
            nodes.get(edges[j][1]).add(edges[j][0]);
            neighbors[edges[j][0]]++;
            neighbors[edges[j][1]]++;
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int k = 0; k < n; k++) {
        	if (nodes.get(k).size() <= 1) {
        		leaves.add(k);
        	}
        }
        
        while (n > 2) {
        	List newleaves = new ArrayList<Integer>();
        	for (int leave : leaves) {
        		n-=1;
        		for (int node : nodes.get(leave)) {
        			if (--neighbors[node] == 1) {
        				newleaves.add(node);
        			}
        		}
        	}
        	leaves = newleaves;
        }
        
        return leaves;
    }
}