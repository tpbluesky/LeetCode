package Problem99;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private TreeNode firstElem = null, secondElem = null, preNode = null;

    public void recoverTree(TreeNode root) {
        firstElem = secondElem = preNode = null;
        inorder(root);
        int t = firstElem.val;
        firstElem.val = secondElem.val;
        secondElem.val = t;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (firstElem == null && preNode != null && preNode.val > root.val) {
            firstElem = preNode;
        }
        if (firstElem != null && firstElem.val > root.val) {
            secondElem = root;
        }
        preNode = root;
        inorder(root.right);
    }
}
