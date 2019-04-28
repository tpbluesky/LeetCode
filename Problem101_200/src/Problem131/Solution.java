package Problem131;

import java.util.ArrayList;
import java.util.List;

/**
 * 直接dfs即可
 */
class Solution {

    private static List<List<String>> ans = null;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(String s, int cur, List<String> res) {
        if (cur >= s.length()) {
            ans.add(new ArrayList<>(res));
        }
        for (int i = 0; i < s.length() - cur; ++i) {
            if (isOk(s, cur, cur + i)) {
                res.add(s.substring(cur, cur + i + 1));
                dfs(s, cur + i + 1, res);
                res.remove(res.size() - 1);
            }
        }
    }

    public boolean isOk(String s, int b, int e) {
        if (b == e) return true;
        while (b < e) {
            if (s.charAt(b++) != s.charAt(e--)) return false;
        }
        return true;
    }
}