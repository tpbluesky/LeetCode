package Problem122;

import java.util.Stack;

class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (!stack.isEmpty()) {
                int res = 0;
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    res = Math.max(res, stack.peek() - stack.get(0));
                    stack.pop();
                }
                ans += res;
                if (res > 0) stack.clear();
            }
            stack.push(prices[i]);
        }
        if (stack.size() >= 2) {
            ans += stack.peek() - stack.get(0);
        }
        return ans;
    }
}
