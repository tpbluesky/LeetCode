package Problem10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean isMatch1(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    //动态规划解法
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        //dp[i][j]表示s[i->slen] 与p[j->plen]是否匹配
        boolean dp[][] = new boolean[slen + 1][plen + 1];
        //起始两空串匹配
        dp[slen][plen] = true;
        for (int i = slen; i >= 0; i--) {
            for (int j = plen - 1; j >= 0; j--) {
                //判断s[i]和p[j]是否匹配
                boolean match = i < slen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                //如果p[j]是*,有两种情况:
                // 1： *代表匹配0次，dp[i][j] = dp[i][j+2]
                // 2:  *代表重复1次，dp[i][j] = dp[i+1][j] && s[i]和p[j]是否匹配
                ///如果p[j]不是*，那就看dp[i+1][j+1] && s[i]和p[j]是否匹配
                if (j + 1 < plen && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            String s = sin.nextLine();
            String p = sin.nextLine();
            System.out.println(new Solution().isMatch(s, p));
        }
    }
}