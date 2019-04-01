package Problem58;

import java.util.Arrays;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
        return s1[s1.length - 1].length();
    }
}