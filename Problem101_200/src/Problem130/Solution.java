package Problem130;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private boolean vis[][] = null;
    private int n, m;
    private boolean included;

    public void solve(char[][] board) {
        if (board == null) return;
        n = board.length;
        m = n > 0 ? board[0].length : 0;
        if (n == 0 || m == 0) return;
        vis = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    vis[i][j] = true;
                    included = true;
                    dfs(board, i, j, list);
                    if (included) {
                        for (Pair<Integer, Integer> pair : list) {
                            board[pair.getKey()][pair.getValue()] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean isok(char[][] board, int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && board[x][y] == 'O';
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private void dfs(char[][] board, int x, int y, List<Pair<Integer, Integer>> list) {
        list.add(new Pair<>(x, y));
        if (x == 0 || y == 0 || x == n - 1 || y == m - 1) included = false;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i], ty = y + dy[i];
            if (isok(board, tx, ty) && !vis[tx][ty]) {
                vis[tx][ty] = true;
                dfs(board, tx, ty, list);
            }
        }
    }
}