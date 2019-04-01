package Problem78;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.clear();
        for (int i = 0; i <= nums.length; ++i) {
            dfs(0, nums.length, i, 0, nums, new int[i]);
        }
        return ans;
    }

    public void dfs(int cur, int n, int k, int pos, int[] given, int[] nums) {
        if (k == 0) {
            List<Integer> res = new ArrayList<>();
            for (Integer x : nums) res.add(x);
            ans.add(res);
            return;
        }
        if (cur + k > n) return;
        nums[pos] = given[cur];
        dfs(cur + 1, n, k - 1, pos + 1, given, nums);
        dfs(cur + 1, n, k, pos, given, nums);
    }
}
