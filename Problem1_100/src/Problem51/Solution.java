package Problem51;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ans.clear();
        dfs(new boolean[n], new int[n][n], 0);
        return ans;
    }

    public void dfs(boolean vis[], int cur[][], int col) {
        if (col == vis.length) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < vis.length; ++i) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < vis.length; j++) {
                    sb.append(cur[i][j] == 0 ? "." : "Q");
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }
        for (int i = 0; i < vis.length; ++i) {
            if (!vis[i] && check(col, i, cur)) {
                vis[i] = true;
                cur[col][i] = 1;
                dfs(vis, cur, col + 1);
                vis[i] = false;
                cur[col][i] = 0;
            }
        }
    }

    private boolean check(int x, int y, int[][] cur) {
        int k = 1;
        for (int i = x - 1; i >= 0; --i, k++) {
            if ((y - k >= 0 && cur[i][y - k] == 1) || (y + k < cur[0].length && cur[i][y + k] == 1)) return false;
        }
        return true;
    }
}
