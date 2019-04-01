package Problem87;

import java.util.Arrays;

class Solution {

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len == 0) return true;
        if (len == 1) return s1.charAt(0) == s2.charAt(0);
        if (len == 2) return s1.equals(s2) || (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0));
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < len; ++i) if (a[i] != b[i]) return false;
        for (int i = 1; i < len; ++i) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
