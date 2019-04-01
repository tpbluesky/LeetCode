package Problem40;

import java.util.*;

class Solution {

    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans.clear();
        Arrays.sort(candidates);
        List<Integer> res = new ArrayList<>();
        dfs(target, candidates, res, 0);
        return new ArrayList<>(ans);
    }

    private void dfs(int target, int[] candidates, List<Integer> res, int x) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if (x >= candidates.length) return;
        if (target >= candidates[x]) {
            res.add(candidates[x]);
            dfs(target - candidates[x], candidates, res, x + 1);
            res.remove(res.size() - 1);
        }
        dfs(target, candidates, res, x + 1);
    }
}
