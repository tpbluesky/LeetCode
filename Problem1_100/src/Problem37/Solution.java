package Problem37;

class Solution {

    boolean visX[][] = new boolean[10][10];
    boolean visY[][] = new boolean[10][10];
    boolean visBox[][] = new boolean[10][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 10; ++i)
            for (int j = 0; j < 10; j++) {
                visX[i][j] = false;
                visY[i][j] = false;
                visBox[i][j] = false;
            }
        checkX(board);
        checkY(board);
        checkBox(board);
        // System.out.println(visY[7][8]);
        dfs(board, 0);
    }

    private boolean dfs(char board[][], int pos) {
        // System.out.println(pos);
        if (pos >= 81) return true;
        int x = pos / 9, y = pos % 9;
        if (Character.isDigit(board[x][y])) {
            // System.out.println(pos);
            return dfs(board, pos + 1);
        } else {
            for (int i = 1; i <= 9; ++i) {
                if (!visX[x][i] && !visY[y][i] && !visBox[3 * (x / 3) + (y / 3)][i]) {
                    // System.out.println(x + " " + y + " " + i + " " + visX[x][i] + " " + visY[y][i]);
                    visX[x][i] = true;
                    visY[y][i] = true;
                    visBox[3 * (x / 3) + (y / 3)][i] = true;
                    board[x][y] = (char) (i + '0');
                    if (dfs(board, pos + 1)) return true;
                    // System.out.println(x + " " + y + " " + i);
                    visX[x][i] = false;
                    visY[y][i] = false;
                    visBox[3 * (x / 3) + (y / 3)][i] = false;
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }

    private void checkBox(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!Character.isDigit(board[(i / 3) * 3 + j][(i % 3) * 3 + k])) continue;
                    visBox[i][board[(i / 3) * 3 + j][(i % 3) * 3 + k] - '0'] = true;
                }
            }
        }
    }

    private void checkX(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                if (!Character.isDigit(board[i][j])) continue;
                visX[i][board[i][j] - '0'] = true;
            }
        }
    }

    private void checkY(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; j++) {
                if (!Character.isDigit(board[j][i])) continue;
                visY[i][board[j][i] - '0'] = true;
            }
        }
    }
}

