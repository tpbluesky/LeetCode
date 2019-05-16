package Problem140;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据dp结果倒推
 */
class Solution {
    private List<String> ans = null;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        s = "#" + s;
        boolean dp[] = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); ++i) {
            for (String str : wordDict) {
                boolean ok = i >= str.length() ? dp[i - str.length()] && str.equals(s.substring(i + 1 - str.length(), i + 1)) : dp[i];
                if (ok) dp[i] = true;
            }
        }
        if (!dp[s.length() - 1]) return ans;
        dfs(dp, s, wordDict, s.length() - 1, new ArrayList<String>());
        return ans;
    }

    public void dfs(boolean[] dp, String s, List<String> wordDict, int cur, List<String> res) {
        if (cur == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
                if (i != res.size() - 1) sb.append(" ");
            }
            ans.add(sb.toString());
        }
        for (String str : wordDict) {
            if (cur - str.length() >= 0 && dp[cur - str.length()] && str.equals(s.substring(cur + 1 - str.length(), cur + 1))) {
                res.add(0, str);
                dfs(dp, s, wordDict, cur - str.length(), res);
                res.remove(0);
            }
        }
    }
}
