package Problem85;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;
        if (m == 0) return 0;
        int mp[][] = new int[n][m + 2];
        for (int i = 0; i < m; ++i) mp[0][i + 1] = matrix[0][i] - '0';
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                mp[i][j + 1] = matrix[i][j] == '1' ? mp[i - 1][j + 1] + 1 : 0;
            }
        }
        for (int i = 0; i < n; ++i)
            System.out.println(Arrays.toString(mp[i]));
        int max_val = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < m+2; j++) {
                if (!s.isEmpty()) {
                    if (mp[i][j] <= mp[i][s.peek()]) {
                        while (!s.isEmpty() && mp[i][j] <= mp[i][s.peek()]) {
                            int t = s.pop();
                            max_val = Math.max(max_val, mp[i][t] * (j - (s.isEmpty()?0:s.peek()) - 1));
                        }
                    }
                }
                s.push(j);
            }
        }
        return max_val;
    }
}
