package Problem145;


import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        HashSet<TreeNode> hs = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null && !hs.contains(cur.left)) {
                stack.push(cur);
                stack.push(cur.left);
                continue;
            }
            if (cur.right != null && !hs.contains(cur.right)) {
                stack.push(cur);
                stack.push(cur.right);
                continue;
            }
            ans.add(cur.val);
            hs.add(cur);
        }
        return ans;
    }
}
