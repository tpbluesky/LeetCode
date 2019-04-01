package Problem9;

import java.util.Scanner;

class Solution {
    public boolean isPalindrome1(int x) {
        String s = "" + x;
        if (s.length() <= 1) return true;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long t = x;
        long p = 0;
        while (x != 0) {
            p = p * 10 + (x % 10);
            x /= 10;
            if (p == 0) return false;
        }
        return t == p;
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            System.out.println(new Solution().isPalindrome(sin.nextInt()));
        }
    }
}