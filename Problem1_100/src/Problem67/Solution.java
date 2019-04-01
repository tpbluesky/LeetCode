package Problem67;

class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length() - 1, len2 = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        int pre = 0;
        while (len1 >= 0 || len2 >= 0) {
            int t = ((len1 >= 0) ? a.charAt(len1) - '0' : 0) + ((len2 >= 0) ? b.charAt(len2) - '0' : 0) + pre;
            sb.append(t % 2);
            pre = t / 2;
            len1--;
            len2--;
        }
        if (pre > 0) sb.append(pre);
        return sb.reverse().toString();
    }
}
