package Problem73;

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0] == null ? 0 : matrix[0].length;
        if (n == 0 || m == 0) return;
        int h[] = new int[m];
        int v[] = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    v[i] = h[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                if (v[i] == 1 || h[j] == 1) matrix[i][j] = 0;
            }
        }
    }
}
