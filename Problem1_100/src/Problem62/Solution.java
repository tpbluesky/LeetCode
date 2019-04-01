package Problem62;

class Solution {
    public int uniquePaths(int m, int n) {
        int x = m + n - 2, y = Math.min(m, n) - 1;
        long ans = 1;
        for (int i = 1; i <= y; ++i)
            ans = ans * (x - i + 1) / i;
        return (int) ans;
    }

}
