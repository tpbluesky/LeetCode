package Problem127;

import java.util.*;

class Solution {

    static class Pair {
        String key;
        int val;

        Pair(String k, int v) {
            key = k;
            val = v;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) < 0) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> words = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair p = ((LinkedList<Pair>) queue).pop();
            String cur = p.key;
            if (cur.equals(endWord)) return p.val;
            for (int i = 0; i < cur.length(); ++i) {
                char str[] = cur.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == str[i]) continue;
                    str[i] = j;
                    String t = new String(str);
                    if (!vis.contains(t) && words.contains(t)) {
                        vis.add(t);
                        ((LinkedList<Pair>) queue).addLast(new Pair(t, p.val + 1));
                    }
                }
            }
        }
        return 0;
    }
}