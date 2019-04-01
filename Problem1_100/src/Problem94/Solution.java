package Problem94;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inoder(root, ans);
        return ans;
    }

    public void inoder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inoder(root.left, ans);
        ans.add(root.val);
        inoder(root.right, ans);
    }
}
