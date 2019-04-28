package Problem133;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

/**
 * A节点的neighbors包含B，B的neighbors也包含A，为了避免重复创建
 * 可以用一个HashMap将原始节点和新节点对应一起
 */
class Solution {

    private HashMap<Node, Node> hmap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (hmap.containsKey(node)) return hmap.get(node);
        Node root = new Node(node.val, new ArrayList<>());
        hmap.put(node, root);
        for (Node n : node.neighbors) {
            Node g = cloneGraph(n);
            root.neighbors.add(g);
        }
        return root;
    }
}