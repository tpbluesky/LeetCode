package Problem129;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        dfs(root, root.val);
        return sum;
    }

    private void dfs(TreeNode root, int res) {
        if (root.left == null && root.right == null) {
            sum += res;
        }
        if (root.left != null) {
            dfs(root.left, res * 10 + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, res * 10 + root.right.val);
        }
    }
}
