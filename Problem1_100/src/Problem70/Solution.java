package Problem70;

class Solution {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        int a = 2, b = 3;
        for (int i = 4; i <= n; ++i) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }




}
