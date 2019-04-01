package Problem95;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        ans.clear();
        if(n == 0) return ans;
        dfs(0, n, new int[n + 1], new int[n]);
        return ans;
    }

    public void dfs(int cur, int n, int vis[], int res[]) {
        if (cur >= n) {
            TreeNode root = new TreeNode(res[0]);
            for (int i = 1; i < n; ++i) {
                build(root, res[i]);
            }
            for (TreeNode t : ans) {
                if (compare(t, root)) return;
            }
            ans.add(root);
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (vis[i] == 0) {
                vis[i] = 1;
                res[cur] = i;
                dfs(cur + 1, n, vis, res);
                vis[i] = 0;
            }
        }
    }

    public void build(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            build(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            build(root.right, val);
        }
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) return false;
            return compare(root1.left, root2.left) && compare(root1.right, root2.right);
        }
        return false;
    }
}
