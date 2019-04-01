package Problem38;

class Solution {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuffer sb = new StringBuffer();
            int len = s.length();
            int cnt = 1, j = 1;
            for (; j < len; j++) {
                if (s.charAt(j) == s.charAt(j - 1)) cnt++;
                else {
                    sb.append(cnt);
                    sb.append(s.charAt(j - 1));
                    cnt = 1;
                }
            }
            sb.append(cnt);
            sb.append(s.charAt(j - 1));
            s = sb.toString();
        }
        return s;
    }
}