package Problem54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int n = matrix.length, m = matrix[0].length;
        int cnt = 1, i = 0, j = 0;
        ans.add(matrix[0][0]);
        matrix[0][0] = Integer.MIN_VALUE;
        while (cnt < n * m) {
            while (j + 1 < m && matrix[i][j + 1] != Integer.MIN_VALUE) {
                ans.add(matrix[i][j + 1]);
                matrix[i][1 + j++] = Integer.MIN_VALUE;
                cnt++;
            }
            while (i + 1 < n && matrix[i + 1][j] != Integer.MIN_VALUE) {
                ans.add(matrix[i + 1][j]);
                matrix[1 + i++][j] = Integer.MIN_VALUE;
                cnt++;
            }
            if (cnt == n * m) break;
            while (j - 1 >= 0 && matrix[i][j - 1] != Integer.MIN_VALUE) {
                ans.add(matrix[i][j - 1]);
                matrix[i][-1 + j--] = Integer.MIN_VALUE;
                cnt++;
            }
            while (i - 1 >= 0 && matrix[i - 1][j] != Integer.MIN_VALUE) {
                ans.add(matrix[i - 1][j]);
                matrix[-1 + i--][j] = Integer.MIN_VALUE;
                cnt++;
            }
        }
        return ans;
    }
}