package Problem7;

import java.util.Scanner;

class Solution {

    public int reverse(int x) {
        if (x > -10 && x < 10) return x;
        int sign = x < 0 ? -1 : 1;
        long xx = Math.abs((long) x);
        String s = "" + xx;
        StringBuilder sb = new StringBuilder();
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == '0') idx--;
        while (idx >= 0) sb.append(s.charAt(idx--));
        long ans = Long.parseLong(sb.toString()) * sign;
        if (ans > (1 << 31) - 1 || ans < -(1 << 31)) ans = 0;
        return (int) ans;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            int x = sin.nextInt();
            System.out.println(new Solution().reverse(x));
        }
    }
}