package Problem8;

import java.util.Scanner;

class Solution {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
        int sign = 1;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            str = str.substring(1);
        }
        int end = 0;
        int len = str.length();
        while (end < len && Character.isDigit(str.charAt(end))) end++;
        String ans = str.substring(0, end);
        end = 0;
        len = ans.length();
        while (end < len && ans.charAt(end) == '0') end++;
        ans = ans.substring(end);
        if (ans.length() == 0) return 0;
        if (ans.length() > 11) ans = ans.substring(0, 12);
        long res = Long.parseLong(ans) * sign;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            String str = sin.nextLine();
            System.out.println(new Solution().myAtoi(str));
        }
    }
}