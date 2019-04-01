package Problem30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return ans;
        Arrays.sort(words);
        HashSet<String> wordsSet = new HashSet<>();
        for (String x : words) wordsSet.add(x);
        int singleLens = words[0].length();
        int totalLens = singleLens * words.length;
        int lens = s.length();
        for (int i = 0; i < lens - totalLens + 1; ++i) {
            if (!wordsSet.contains(s.substring(i, i + singleLens))) continue;
            String str = s.substring(i, i + totalLens);
            String[] wds = new String[words.length];
            for (int j = 0; j < words.length; j++) {
                wds[j] = str.substring(singleLens * (j), singleLens * (j + 1));
            }
            Arrays.sort(wds);
            int k = 0;
            for (k = 0; k < words.length; ++k) {
                if (!words[k].equals(wds[k])) break;
            }
            if (k < words.length) continue;
            ans.add(i);
        }
        return ans;
    }
}