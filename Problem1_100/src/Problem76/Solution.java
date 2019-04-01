package Problem76;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public String minWindow1(String s, String t) {
        int len = s.length();
        int tlen = t.length();
        int vis[] = new int[128];
        for (int i = 0; i < tlen; ++i)
            vis[t.charAt(i)]++;
        List<Pair> nums = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            int tp = s.charAt(i);
            if (vis[tp] != 0) {
                nums.add(new Pair(tp, i));
            }
        }
        if (nums.size() < tlen) return "";
        Pair windows[] = new Pair[nums.size() + 5];
        int head = 0, tail = 0;
        int cnt[] = new int[128];
        int ans = Integer.MAX_VALUE, l = 0, r = 0;
        windows[tail++] = nums.get(0);
        cnt[nums.get(0).first]++;
        for (int i = 1; i <= nums.size(); ++i) {
            if (compare(vis, cnt)) {
                int p = windows[tail - 1].index - windows[head].index + 1;
                if (ans > p) {
                    ans = p;
                    r = windows[tail - 1].index;
                    l = windows[head].index;
                }
            }
            if (i == nums.size()) break;
            Pair k = nums.get(i);
            if (windows[head].first == k.first && cnt[k.first] >= vis[k.first]) {
                head++;
                if (head < tail) {
                    int q = windows[head].first;
                    while (head < tail && cnt[q] > vis[q]) {
                        head++;
                        cnt[q]--;
                        if (head < tail)
                            q = windows[head].first;
                    }
                }
                windows[tail++] = k;
                continue;
            }
            windows[tail++] = k;
            cnt[k.first]++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(l, r + 1);
    }

    public boolean compare(int vis[], int cnt[]) {
        for (int i = 0; i < vis.length; ++i)
            if (vis[i] > cnt[i]) return false;
        return true;
    }

    class Pair {
        int first, index;

        public Pair(int f, int s) {
            first = f;
            index = s;
        }
    }

    public String minWindow(String s, String t) {
        int vis[] = new int[128];
        for (char i : t.toCharArray()) vis[i]++;
        int cnt = t.length();
        int l = 0;
        int ansl = -1, ansr = 0;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (vis[s.charAt(i)]-- > 0) cnt--;
            while (cnt == 0) {
                if (ansl == -1 || i - l >= ansr - ansl) {
                    ansl = l;
                    ansr = i;
                }
                if (vis[s.charAt(l++)]++ == 0) {
                    System.out.println(s.charAt(i)+" "+cnt);
                    cnt++;
                }
            }
        }
        return ansl == -1 ? "" : s.substring(ansl, ansr + 1);
    }
}
