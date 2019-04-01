package Problem105;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pos, int l, int r) {
        if (l > r || pos >= inorder.length) return null;
        TreeNode root = new TreeNode(preorder[pos]);
        int i = l, cnt = 0;
        for (; i <= r; ++i) {
            if (preorder[pos] == inorder[i]) break;
            cnt++;
        }
        root.left = dfs(preorder, inorder, pos + 1, l, i - 1);
        root.right = dfs(preorder, inorder, pos + cnt + 1, i + 1, r);
        return root;
    }

}
