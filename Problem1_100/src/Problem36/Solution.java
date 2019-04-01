package Problem36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (checkX(board) && checkY(board) && checkBox(board)) return true;
        return false;
    }

    private boolean checkBox(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] vis = new boolean[10];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!Character.isDigit(board[(i / 3) * 3 + j][(i % 3) * 3 + k])) continue;
                    if (vis[board[(i / 3) * 3 + j][(i % 3) * 3 + k] - '0']) return false;
                    vis[board[(i / 3) * 3 + j][(i % 3) * 3 + k] - '0'] = true;
                }
            }
        }
        return true;
    }

    private boolean checkX(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            boolean[] vis = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!Character.isDigit(board[i][j])) continue;
                if (vis[board[i][j] - '0']) return false;
                vis[board[i][j] - '0'] = true;
            }
        }
        return true;
    }

    private boolean checkY(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            boolean[] vis = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!Character.isDigit(board[j][i])) continue;
                if (vis[board[j][i] - '0']) return false;
                vis[board[j][i] - '0'] = true;
            }
        }
        return true;
    }
}

