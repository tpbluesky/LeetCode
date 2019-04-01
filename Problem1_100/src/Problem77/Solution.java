package Problem77;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        ans.clear();
        dfs(1, n, k, 0, new int[k]);
        return ans;
    }

    public void dfs(int cur, int n, int k, int pos, int[] nums) {
        if (k == 0) {
            List<Integer> res = new ArrayList<>();
            for (Integer x : nums) res.add(x);
            ans.add(res);
            return;
        }
        if (cur + k > n + 1) return;
        nums[pos] = cur;
        dfs(cur + 1, n, k - 1, pos + 1, nums);
        dfs(cur + 1, n, k, pos, nums);
    }
}
