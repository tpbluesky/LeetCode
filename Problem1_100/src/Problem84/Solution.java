package Problem84;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 2];
        for (int i = 0; i < heights.length; ++i) h[i + 1] = heights[i];
        Stack<Integer> s = new Stack<>();
        int max_val = 0;
        for (int i = 0; i < h.length; ++i) {
            if (!s.isEmpty()) {
                if (h[i] < h[s.peek()]) {
                    while (!s.isEmpty() && h[i] < h[s.peek()]) {
                        int t = s.pop();
                        max_val = Math.max(max_val, h[t] * (i - s.peek() - 1));
                    }
                }
            }
            s.push(i);
        }
        return max_val;
    }
}