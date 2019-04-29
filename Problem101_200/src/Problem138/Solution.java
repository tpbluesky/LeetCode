package Problem138;

import java.util.HashMap;

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

class Solution {

    private HashMap<Node, Node> mp = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (mp.containsKey(head)) {
            return mp.get(head);
        }
        Node n = new Node();
        mp.put(head, n);
        n.val = head.val;
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        return n;
    }
}