package Problem113;

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

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans.clear();
        dfs(root, new ArrayList<>(), sum);
        return ans;
    }

    public void dfs(TreeNode root, List<TreeNode> ns, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode t : ns) {
                    res.add(t.val);
                }
                res.add(root.val);
                ans.add(res);
            }
            return;
        }
        ns.add(root);
        dfs(root.left, ns, sum - root.val);
        dfs(root.right, ns, sum - root.val);
        ns.remove(ns.size() - 1);
    }
}