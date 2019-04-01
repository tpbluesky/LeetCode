package Problem59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0) return ans;
        int cnt = 1, i = 0, j = 0;
        ans[0][0] = cnt++;
        while (cnt <= n * n) {
            while (j + 1 < n && ans[i][j + 1] == 0) {
                ans[i][1 + j++] = cnt++;
            }
            while (i + 1 < n && ans[i + 1][j] == 0) {
                ans[1 + i++][j] = cnt++;
            }
            if (cnt > n * n) break;
            while (j - 1 >= 0 && ans[i][j - 1] == 0) {
                ans[i][-1 + j--] = cnt++;
            }
            while (i - 1 >= 0 && ans[i - 1][j] == 0) {
                ans[-1 + i--][j] = cnt++;
            }
        }
        return ans;
    }
}
