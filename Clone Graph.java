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
            return node;
        }

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();

        // key: old node, value: new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode root = new UndirectedGraphNode(node.label);

        map.put(node, root);
        queue.addLast(node);


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode oldNode = queue.pollFirst();
                List<UndirectedGraphNode> children = oldNode.neighbors;
                for (UndirectedGraphNode child : children) {
                    if (!map.containsKey(child)) {
                        map.put(child, new UndirectedGraphNode(child.label));
                        queue.addLast(child);
                    }
                    map.get(oldNode).neighbors.add(map.get(child));
                }
            }

        }

        return root;
    }
}