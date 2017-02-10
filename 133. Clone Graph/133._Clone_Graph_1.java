/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return getGraph(node, new HashMap<Integer, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode getGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> ex) {
        //System.out.println("label" + node.label);
        if (ex.containsKey(node.label)) {
            return ex.get(node.label);
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        ex.put(node.label, result);
        List<UndirectedGraphNode> result_neighbors = new ArrayList<UndirectedGraphNode>();
        if (node.neighbors != null) {
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode result_neighbor = getGraph(node.neighbors.get(i), ex);
                result_neighbors.add(result_neighbor);
            }
        }
        result.neighbors = result_neighbors;
        return result;
    }
}