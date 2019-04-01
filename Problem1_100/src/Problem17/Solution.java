package Problem17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static final String values = "abcdefghijklmnopqrstuvwxyz";
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        ans.clear();
        if(digits.length() == 0) return ans;
        dfs(digits, 0, "");
        return ans;
    }

    public void dfs(String digits, int pos, String res) {
        if (pos >= digits.length()) {
            ans.add(res);
            return;
        }
        int x = digits.charAt(pos) - '0';
        int num = x == 7 || x == 9 ? 4 : 3;
        int start = getPos(x);
        for (int i = 0; i < num; ++i) {
            dfs(digits, pos + 1, res + values.charAt(start + i));
        }
    }

    public int getPos(int x) {
        if (x < 7) return 3 * (x - 2);
        if (x == 7) return 15;
        if (x == 8) return 19;
        if (x == 9) return 22;
        return 0;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            List<String> strings = new Solution().letterCombinations(sin.nextLine());
            for (String x : strings) {
                System.out.println(x + " ");
            }
        }

    }
}