package Problem52;

public class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        dfs(new boolean[n], new int[n][n], 0);
        return ans;
    }

    public void dfs(boolean vis[], int cur[][], int col) {
        if (col == vis.length) {
            ans++;
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
