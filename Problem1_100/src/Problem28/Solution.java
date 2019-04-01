package Problem28;

class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) return 0;
        if (len1 < len2) return -1;
        for (int i = 0; i < len1 - len2 + 1; ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < len2) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    j++;
                }
                if (j == len2) {
                    return i;
                }
            }
        }
        return -1;
    }
}