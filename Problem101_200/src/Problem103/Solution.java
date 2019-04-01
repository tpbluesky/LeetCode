package Problem103;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<TreeNode> l2r = new ArrayList<>();
        List<TreeNode> r2l = new ArrayList<>();
        l2r.add(root);
        int level = 0;
        while (l2r.size() > 0 || r2l.size() > 0) {
            List<Integer> res = new ArrayList<>();
            if (level % 2 == 0) {
                r2l.clear();
                for(TreeNode x:l2r){
                    res.add(x.val);
                }
                for (int i = l2r.size() - 1; i >= 0; i--) {
                    TreeNode x = l2r.get(i);
                    if (x.right != null) r2l.add(x.right);
                    if (x.left != null) r2l.add(x.left);
                }
                if(res.size() > 0)
                    ans.add(res);
            } else {
                l2r.clear();
                for(TreeNode x:r2l){
                    res.add(x.val);
                }
                for (int i = r2l.size() - 1; i >= 0; i--) {
                    TreeNode x = r2l.get(i);
                    if (x.left != null) l2r.add(x.left);
                    if (x.right != null) l2r.add(x.right);
                }
                if(res.size() > 0)
                    ans.add(res);
            }
            level++;
        }
        return ans;
    }
}
