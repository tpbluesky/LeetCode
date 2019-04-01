package Problem91;

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() < 2) return s.length();
        int dp[] = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        int t = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        if (s.charAt(1) == '0' && t > 20) return 0;
        dp[2] = t <= 26 && t > 10 ? 2 : 1;
        dp[2] = t == 20 ? 1 : dp[2];
        System.out.println(dp[1] + " " + dp[2]);
        for (int i = 2; i < s.length(); ++i) {
            t = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (s.charAt(i) == '0' && t > 20) return 0;
            System.out.println(t);
            dp[i + 1] = (s.charAt(i) == '0') ? 0 : dp[i] + (t <= 26 && t >= 10 ? dp[i - 1] : 0);
        }
        return dp[s.length()];
    }
}
