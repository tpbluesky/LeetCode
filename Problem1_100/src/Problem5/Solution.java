package Problem5;

import java.util.Scanner;

class Solution {

    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        int dp[][] = new int[1005][1005];
        int l = s.length();
        for (int i = 0; i < l; ++i) dp[i][i] = 1;
        for (int i = 0; i < l - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = 2;
            else dp[i][i + 1] = 1;
        }
        for (int k = 3; k <= l; ++k) {
            for (int i = 0; i <= l - k; ++i) {
                if (s.charAt(i) == s.charAt(i + k - 1) && dp[i + 1][i + k - 2] == k - 2) {
                    dp[i][i + k - 1] = k;
                } else {
                    dp[i][i + k - 1] = Math.max(dp[i + 1][i + k - 1], dp[i][i + k - 2]);
                }
            }
        }
        int ml = dp[0][l - 1];
//        System.out.println(ml);
        String ans = "";
        for (int i = 0; i <= l - ml; ++i) {
            if (dp[i][i + ml - 1] == ml) {
                ans = s.substring(i, i + ml);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()){
            String s = sin.nextLine();
            System.out.println(new Solution().longestPalindrome(s));
        }
    }
}