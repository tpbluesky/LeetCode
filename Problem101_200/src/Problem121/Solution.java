package Problem121;

import java.util.Stack;

class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    ans = Math.max(ans, stack.peek() - stack.get(0));
                    stack.pop();
                }
            }
            stack.push(prices[i]);
        }
        if (stack.size() >= 2) {
            ans = Math.max(ans, stack.peek() - stack.get(0));
        }
        return ans;
    }
}
