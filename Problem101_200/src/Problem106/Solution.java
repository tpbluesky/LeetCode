package Problem106;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] postorder, int[] inorder, int pos, int l, int r) {
        if (l > r || pos < 0) return null;
        TreeNode root = new TreeNode(postorder[pos]);
        int i = r, cnt = 0;
        for (; i >= l; --i) {
            if (postorder[pos] == inorder[i]) break;
            cnt++;
        }
        root.right = dfs(postorder, inorder, pos - 1, i + 1, r);
        root.left = dfs(postorder, inorder, pos - cnt - 1, l, i - 1);
        return root;
    }
}
