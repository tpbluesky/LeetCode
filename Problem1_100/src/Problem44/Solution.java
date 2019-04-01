package Problem44;

class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean dp[][] = new boolean[ls + 1][lp + 1];
        dp[ls][lp] = true;
        for (int i = ls; i >= 0; --i) {
            for (int j = lp - 1; j >= 0; j--) {
                boolean isMatch = (i < ls && s.charAt(i) == p.charAt(j)) || p.charAt(j) == '?';
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j + 1] || (i + 1 <= ls && dp[i + 1][j]);
                } else {
                    dp[i][j] = isMatch && i + 1 <= ls && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}