package Problem12;

import java.util.Scanner;

class Solution {

    public String intToRoman(int num) {
        String val[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int key[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < key.length && num > 0; ++i) {
            int t = num / key[i];
            for (int j = 0; j < t; j++) sb.append(val[i]);
            num %= key[i];
        }
        return sb.toString();
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            System.out.println(new Solution().intToRoman(sin.nextInt()));
        }
    }
}