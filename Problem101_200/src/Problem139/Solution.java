package Problem139;

import java.util.List;

/**
 * 简单动态规划
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        s = "#" + s;
        boolean dp[] = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); ++i) {
            for (String str : wordDict) {
                dp[i] = i >= str.length() ? dp[i - str.length()] && str.equals(s.substring(i + 1 - str.length(), i + 1)) : dp[i];
                if (dp[i]) break;
            }
        }
        return dp[s.length() - 1];
    }
}