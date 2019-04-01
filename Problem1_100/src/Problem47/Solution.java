package Problem47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans.clear();
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return new ArrayList<>(ans);
    }

    void dfs(int[] nums, boolean[] vis, List<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!vis[i]) {
                vis[i] = true;
                res.add(nums[i]);
                dfs(nums, vis, res);
                vis[i] = false;
                res.remove(res.size() - 1);
            }
        }
    }
}