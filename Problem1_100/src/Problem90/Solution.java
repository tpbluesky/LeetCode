package Problem90;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i <= (1 << len); ++i) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < len; ++j) {
                if ((i & (1 << j)) != 0) t.add(nums[j]);
            }
            res.add(t);
        }
        ans.addAll(res);
        return ans;
    }
}
