package Problem114;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode last = null;

    public void flatten(TreeNode root) {
        last = null;
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        dfs(root.left);
        if (last != null) {
            root.left = null;
            root.right = last;
        }
        if (root != null) last = root;
    }
}

