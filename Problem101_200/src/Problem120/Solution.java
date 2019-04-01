package Problem120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()  == 0) return 0;
        int n = triangle.get(triangle.size() - 1).size();
        int dp[] = new int[n];
        for (int i = 0; i < triangle.size(); ++i) {
            List<Integer> t = triangle.get(i);
            for (int j = t.size() - 1; j >= 0; j--) {
                if (j == t.size() - 1 || j == 0) {
                    dp[j] = (j == 0 ? dp[j] : dp[j - 1]) + t.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + t.get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
