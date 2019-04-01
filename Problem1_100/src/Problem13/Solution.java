package Problem13;

import java.util.Scanner;

class Solution {

    public int romanToInt(String s) {
        String val[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int key[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int ans = 0;
        for (int i = 0; i < val.length; ++i) {
            while (s.startsWith(val[i])) {
                ans += key[i];
                s = s.substring(val[i].length());
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            System.out.println(new Solution().romanToInt(sin.nextLine()));
        }
    }
}