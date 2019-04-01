package Problem117;

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
        while (preLevel != null) {
            TreeLinkNode p = preLevel;
            TreeLinkNode q = null;
            boolean flag = false;
            preLevel = null;
            while (p != null) {
                if (p.left != null) {
                    if (!flag) {
                        preLevel = p.left;
                        q = preLevel;
                        flag = true;
                    } else {
                        q.next = p.left;
                        q = q.next;
                    }
                }
                if (p.right != null) {
                    if (!flag) {
                        preLevel = p.right;
                        q = preLevel;
                        flag = true;
                    } else {
                        q.next = p.right;
                        q = q.next;
                    }
                }
                p = p.next;
            }
        }
    }
}
