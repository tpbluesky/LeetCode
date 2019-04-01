package Problem123;

import java.util.Stack;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int l2r[] = new int[n];
        int r2l[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
            }
            stack.push(prices[i]);
            l2r[i] = i - 1 >= 0 ? Math.max(l2r[i - 1], prices[i] - stack.get(0)) : 0;
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < prices[i]) {
                    stack.pop();
                }
            }
            stack.push(prices[i]);
            r2l[i] = i + 1 < n ? Math.max(r2l[i + 1], stack.get(0) - prices[i]) : 0;
        }
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            ans = Math.max(ans, l2r[i - 1] + r2l[i]);
        }
        return Math.max(ans, l2r[n - 1]);
    }
}