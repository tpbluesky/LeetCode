package Problem39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        List<Integer> res = new ArrayList<>();
        dfs(target, candidates, res, 0);
        return ans;
    }

    private void dfs(int target, int[] candidates, List<Integer> res, int x) {
        // System.out.println(Arrays.toString(res.toArray()));
        if (x >= candidates.length) return;
        if (target == 0) {
            List<Integer> t = new ArrayList<>(res);
            ans.add(t);
            return;
        }
        if (target >= candidates[x]) {
            res.add(candidates[x]);
            dfs(target - candidates[x], candidates, res, x);
            res.remove(res.size() - 1);
        }
        dfs(target, candidates, res, x + 1);
    }
}