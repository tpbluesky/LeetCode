package Problem119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; ++i) {
            int t = 1;
            for (int j = 1; j <= i; j++) {
                int k = nums[j];
                nums[j] = t + nums[j];
                t = k;
            }
        }
        for (int i = 0; i <= rowIndex; ++i)
            ans.add(nums[i]);
        return ans;
    }
}
