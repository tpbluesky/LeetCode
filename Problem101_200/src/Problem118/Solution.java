package Problem118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        List<Integer> last = null;
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int j = 0; j < i - 2; j++) {
                res.add(last.get(j) + last.get(j + 1));
            }
            if (i > 1)
                res.add(1);
            last = res;
            ans.add(res);
        }
        return ans;
    }
}
