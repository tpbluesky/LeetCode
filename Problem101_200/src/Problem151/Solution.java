package Problem151;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        String[] res = s.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = res.length - 1; i >= 0; i--) {
            if (!res[i].trim().equals("")) {
                ans.add(res[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); ++i) {
            sb.append(ans.get(i));
            if (i != ans.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
