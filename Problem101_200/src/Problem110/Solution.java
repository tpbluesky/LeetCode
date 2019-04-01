package Problem110;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private boolean isOk = true;

    public boolean isBalanced(TreeNode root) {
        isOk = true;
        dfs(root);
        return isOk;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int dl = dfs(root.left);
        int dr = dfs(root.right);
        if (Math.abs(dl - dr) >= 2) {
            isOk = false;
        }
        return Math.max(dl, dr) + 1;
    }
}
