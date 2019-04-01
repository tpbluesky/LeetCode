package Problem60;

class Solution {
    public String getPermutation(int n, int k) {
        int fact[] = new int[10];
        fact[1] = 0;
        fact[2] = 1;
        for (int i = 3; i < 10; ++i) {
            fact[i] = fact[i - 1] * (i - 1);
        }
        boolean vis[] = new boolean[n + 1];
        k -= 1;
        StringBuffer sb = new StringBuffer();
        for (int i = n; i >= 1; i--) {
            int x = fact[i] == 0 ? 0 : k / fact[i];
            k -= x * fact[i];
            int j = 1;
            for (; j <= n; j++) {
                if (!vis[j]) x--;
                if (x < 0) break;
            }
            sb.append(j);
            vis[j] = true;
        }
        return sb.toString();
    }
}
