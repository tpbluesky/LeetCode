package Problem116;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode preLevel = root;
        while (preLevel.left != null || preLevel.right != null) {
            TreeLinkNode p = preLevel;
            preLevel = p.left;
            TreeLinkNode q = preLevel;
            while (p != null) {
                q.next = p.right;
                q = q.next;
                p = p.next;
                if (p == null) break;
                q.next = p.left;
                q = q.next;
            }
        }
    }
}
