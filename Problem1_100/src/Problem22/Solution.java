package Problem22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    List<String> ans = new ArrayList<>();
    int total = 0;

    public List<String> generateParenthesis(int n) {
        ans.clear();
        total = n;
        if (n == 0) {
            ans.add("");
            return ans;
        }
        dfs(n, 0, "");
        return ans;
    }

    private void dfs(int n, int i, String res) {
        if (res.length() == 2 * total) {
            ans.add(res);
            return;
        }
        if (n > 0) dfs(n - 1, i + 1, res + "(");
        if (i > 0) dfs(n, i - 1, res + ")");
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
    }
}