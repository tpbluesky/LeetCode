package Problem79;

class Solution {
    int n = 0, m = 0;
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board == null ? 0 : board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] vis = new boolean[n][m];
                    vis[i][j] = true;
                    if (dfs(i, j, board, vis, 1, word)) return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, char[][] board, boolean[][] vis, int pos, String word) {
        if (pos >= word.length()) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= n || ty >= m || tx < 0 || ty < 0 || vis[tx][ty] || board[tx][ty] != word.charAt(pos)) continue;
            vis[tx][ty] = true;
            if (dfs(tx, ty, board, vis, pos + 1, word)) return true;
            vis[tx][ty] = false;
        }
        return false;
    }
}
