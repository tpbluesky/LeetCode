package Problem126;

import java.util.*;

class Solution {

    static class Pair {
        String key;
        int val;
        List<String> path;

        Pair(String k, int v) {
            key = k;
            val = v;
            path = new ArrayList<>();
            path.add(k);
        }
    }

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans.clear();
        Set<String> words = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(beginWord, 1));
        int cur_step = 1;
        Set<String> kk = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair p = queue.pop();
            String cur = p.key;
            if (cur.equals(endWord)) {
                ans.add(p.path);
                break;
            }
            if (p.val != cur_step) {
                vis.addAll(kk);
                kk.clear();
                cur_step = p.val;
            }
            for (int i = 0; i < cur.length(); ++i) {
                char str[] = cur.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == str[i]) continue;
                    str[i] = j;
                    String t = new String(str);
                    if (!vis.contains(t) && words.contains(t)) {
                        kk.add(t);
                        Pair tmp = new Pair(t, p.val + 1);
                        tmp.path.addAll(0, p.path);
                        queue.addLast(tmp);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair p = queue.pop();
            if (p.key.equals(endWord)) {
                ans.add(p.path);
            }
        }
        return ans;
    }
}