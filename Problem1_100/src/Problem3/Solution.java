package Problem3;

import java.util.Scanner;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lens = s.length();
        int ans = 0;
        int vis[] = new int[128];
        for (int i = 0; i < vis.length; ++i) vis[i] = -1;
        for (int i = -1, j = 0; j < lens; ++j) {
            i = Math.max(i, vis[s.charAt(j)]);
            ans = Math.max(ans, j - i);
            vis[s.charAt(j)] = j;
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        String test = sin.nextLine();
        System.out.println(new Solution().lengthOfLongestSubstring(test));
    }
}