package Problem107;

import java.util.ArrayDeque;
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

    class Pair {
        int level;
        TreeNode val;

        Pair(TreeNode v, int l) {
            val = v;
            level = l;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.push(new Pair(root, 0));
        int deep = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.pop();
            if (p.level == deep) res.add(p.val.val);
            else {
                ans.add(0, new ArrayList<>(res));
                res.clear();
                res.add(p.val.val);
                deep = p.level;
            }
            if (p.val.left != null) queue.addLast(new Pair(p.val.left, p.level + 1));
            if (p.val.right != null) queue.addLast(new Pair(p.val.right, p.level + 1));
        }
        ans.add(0,res);
        return ans;
    }
}
