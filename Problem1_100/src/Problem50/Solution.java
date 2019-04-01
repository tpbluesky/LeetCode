package Problem50;

class Solution {
    public double myPow1(double x, int n) {
        return Math.pow(x, n);
    }

    public double myPow(double x, int n) {
        boolean neg = n < 0 ? true : false;
        long k = n < 0 ? -(long) n : (long) n;
        double ans = quickPow(x, k);
        return neg ? 1.0 / ans : ans;
    }

    public double quickPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double ans = quickPow(x, n >> 1);
        ans *= ans;
        if (n % 2 == 1) ans *= x;
        return ans;
    }
}