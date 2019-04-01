package Problem89;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        int len = 1 << n;
        int vis[] = new int[len];
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int x = 0, cnt = 0;
        vis[0] = 1;
        while (cnt < len-1) {
            System.out.println(x);
            for (int i = 0; i < n; ++i) {
                int t = x ^ (1 << i);
                if (vis[t] == 0) {
                    vis[t] = 1;
                    ans.add(t);
                    x = t;
                    cnt++;
                    break;
                }
            }
        }
        return ans;
    }
}
