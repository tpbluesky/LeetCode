package Problem49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String x : strs) {
            char t[] = x.toCharArray();
            Arrays.sort(t);
            String tt = new String(t);
            if (mp.containsKey(tt)) {
                mp.get(tt).add(x);
            } else {
                List<String> res = new ArrayList<>();
                res.add(x);
                mp.put(tt, res);
            }
        }
        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }
}