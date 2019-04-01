package Problem93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        ans.clear();
        int len = s.length();
        if (len < 4 || len > 12) return ans;
        dfs(s, 1, new String[4]);
        return ans;
    }

    public void dfs(String s, int cur, String[] res) {
        if (cur > 5) {
            String t = String.join(".", res);
            ans.add(t);
            return;
        }
        int len = s.length();
        for (int i = 1; i <= 3; ++i) {
            if (len - i < 4 - cur || len - i > 12 - 3 * cur) continue;
            String k = s.substring(0, i);
            if (k.charAt(0) == '0' && k.length() > 1) break;
            int j = Integer.parseInt(k);
            if (j > 255) continue;
            res[cur - 1] = k;
            dfs(s.substring(i), cur + 1, res);
        }
    }
}
