package Problem69;

class Solution {
    public int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt(int x) {
        int l = 0, r = x;
        double eps = 1e-9;
        while (l <= r) {
            int t = (l + r) >> 1;
            double k = (double) x / t - t;
            System.out.println(k);
            if (Math.abs(k) < eps) return t;
            if (k < 0) r = t - 1;
            else l = t + 1;
        }
        return r;
    }

}
