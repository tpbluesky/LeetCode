package Problem68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int lens = words.length;
        int cnt = 0, start = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < lens; ++i) {
            //start->(i-1)对齐
            if (cnt + words[i].length() + (i - start) > maxWidth) {
                System.out.println(cnt + " " + i);
                int t = maxWidth - cnt;
                if (i - 1 - start == 0) {
                    ans.add(words[start] + getBlank(maxWidth - words[start].length()));
                    start = i;
                    cnt = 0;
                    cnt += words[i].length();
                    continue;
                }
                int k = t / (i - 1 - start);
                int r = t % (i - 1 - start);
                StringBuffer sb = new StringBuffer();
                sb.append(words[start]);
                for (int j = start + 1; j < i; j++) {
                    if (j - start <= r) {
                        sb.append(getBlank(k + 1));
                    } else {
                        sb.append(getBlank(k));
                    }
                    sb.append(words[j]);
                }
                ans.add(sb.toString());
                start = i;
                cnt = 0;
            }
            cnt += words[i].length();
        }
        StringBuffer sb = new StringBuffer();
        sb.append(words[start]);
        cnt = words[start].length();
        for (int i = start + 1; i < lens; ++i) {
            sb.append(" ");
            sb.append(words[i]);
            cnt += (words[i].length() + 1);
        }
        if (cnt < maxWidth) sb.append(getBlank(maxWidth - cnt));
        ans.add(sb.toString());
        return ans;
    }

    private String getBlank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) sb.append(" ");
        return sb.toString();
    }
}
