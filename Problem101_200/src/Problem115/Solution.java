package Problem115;

class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 == 0) return 0;
        if (len2 == 0) return 1;
        int[][] dp = new int[len2 + 1][len1 + 1];
        for (int i = 1; i <= len1; ++i) {
            dp[1][i] = dp[1][i - 1] + (s.charAt(i - 1) == t.charAt(0) ? 1 : 0);
        }
        for (int i = 2; i <= len2; ++i) {
            for (int j = i; j <= len1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len2][len1];
    }
}
