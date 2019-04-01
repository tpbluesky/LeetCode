package Problem29;

class Solution {
    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        return dividend / divisor;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long newDividend = Math.abs((long) dividend);
        long newDivisor = Math.abs((long) divisor);
        int ans = 0;
        while (newDividend >= newDivisor) {
            long sub = newDivisor;
            long t = 1;
            while (newDividend >= sub) {
                sub <<= 1;
                t <<= 1;
            }
            sub >>= 1;
            t >>= 1;
            newDividend -= sub;
            ans += t;
        }
        return isNeg ? -ans : ans;
    }

}