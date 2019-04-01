package Problem124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l_max = dfs(root.left);
        int r_max = dfs(root.right);
        res = Math.max(res, (l_max <= 0 ? 0 : l_max) + (r_max <= 0 ? 0 : r_max) + root.val);
        return Math.max(l_max <= 0 ? 0 : l_max, r_max <= 0 ? 0 : r_max) + root.val;
    }
}