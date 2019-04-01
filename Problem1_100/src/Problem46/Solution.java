package Problem46;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ans.clear();
        boolean vis[] = new boolean[nums.length];
        List<Integer> res = new ArrayList<>();
        dfs(nums, vis, res);
        return ans;
    }

    private void dfs(int[] nums, boolean[] vis, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!vis[i]) {
                res.add(nums[i]);
                vis[i] = true;
                dfs(nums, vis, res);
                res.remove(res.size() - 1);
                vis[i] = false;
            }
        }
    }
}