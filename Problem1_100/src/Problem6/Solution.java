package Problem6;

import java.util.Scanner;

class Solution {
    public String convert(String s, int numRows) {
        int lens = s.length();
        if (lens <= numRows) return s;
        int width = lens;
        char ans[][] = new char[numRows][width];
        int idx = 0, i = 0;
        while (idx < lens) {
            for (int j = 0; j < numRows && idx < lens; j++) {
                ans[j][i] = s.charAt(idx++);
            }
            for (int j = numRows - 2; j >= 1 && idx < lens; j--) {
                ans[j][++i] = s.charAt(idx++);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < numRows; ++k) {
            for (int j = 0; j < Math.min(i, width); j++) {
                if (ans[k][j] != 0) sb.append(ans[k][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            String s = sin.nextLine();
            int t = sin.nextInt();
            System.out.println(new Solution().convert(s, t));
            sin.nextLine();
        }
    }
}