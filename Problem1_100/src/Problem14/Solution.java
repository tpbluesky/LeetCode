package Problem14;

import java.util.Scanner;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            ans = findMaxCommon(ans, strs[i]);
        }
        return ans;
    }

    private String findMaxCommon(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        String ans = s1.length() > s2.length() ? s2 : s1;
        for (int i = 0; i < minLen; ++i) {
            if (s1.charAt(i) != s2.charAt((i))) {
                ans = s1.substring(0, i);
                break;
            }
        }
        return ans;
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog","d"}));
    }
}