package Problem132;

/**
 * dp[i]:表示从0-i这段字符串最少要切分的次数
 * dp[i] = min(dp[i],dp[j]+1)  j+1->i这一段是回文串
 */
class Solution {

    public int minCut(String s) {
        boolean[][] mp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            mp[i][i] = true;
            if (i + 1 < s.length())
                mp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < s.length(); ++i) {
            for (int j = 0; j + i < s.length(); j++) {
                mp[j][j + i] = s.charAt(j) == s.charAt(i + j) && mp[j + 1][j + i - 1];
            }
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = i;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (mp[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (mp[j + 1][i]) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
