package Problem42;

import java.util.Stack;

class Solution {
    public int trap1(int[] height) {
        if (height.length < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int t = stack.peek();
                stack.pop();
                if (stack.isEmpty()) break;
                int d = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[t];
                ans += h * d;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap2(int[] height) {
        if (height.length < 2) return 0;
        int maxL[] = new int[height.length];
        int maxR[] = new int[height.length];
        maxL[0] = height[0];
        maxR[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; ++i) {
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            ans += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return ans;
    }

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int l_max = 0, r_max = 0;
        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > l_max) l_max = height[l];
                else ans += l_max - height[l];
                l++;
            } else {
                if (height[r] > r_max) r_max = height[r];
                else ans += r_max - height[r];
                r--;
            }
        }
        return ans;
    }
}