package Problem97;

import java.util.Arrays;

class Solution {
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1 + "#", s2 + "#", s3, 0, 0, 0);
    }

    public boolean dfs(String s1, String s2, String s3, int p1, int p2, int cur) {
        if (cur >= s3.length()) return true;
        int t1 = p1, t2 = p2, t3 = cur;
        boolean flag = false;
        while (t3 < s3.length()) {
            boolean b1 = s1.charAt(t1) == s3.charAt(t3);
            boolean b2 = s2.charAt(t2) == s3.charAt(t3);
            if (!b1 && !b2) return false;
            if (b1 && b2) break;
            if (b1) t1++;
            else t2++;
            t3++;
        }
        System.out.println(t1 + " " + t2 + " " + t3);
        System.out.println(s1.charAt(t1) + " " + s2.charAt(t2) + " " + s3.charAt(t3));
        return dfs(s1, s2, s3, t1 + 1, t2, t3 + 1) && dfs(s1, s2, s3, t1, t2 + 1, t3 + 1);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s2.equals("")) return s1.equals(s3);
        if (s1.equals("")) return s2.equals(s3);
        int len1 = s1.length(), len2 = s2.length();
        boolean dp[][] = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int i = 1; i <= len2; i++) dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        for (int i = 0; i <= len1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len1][len2];
    }
}
