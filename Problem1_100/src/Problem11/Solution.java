package Problem11;

import java.util.Scanner;

class Solution {

    public int maxArea1(int[] height) {
        int len = height.length;
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return ans;
    }

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                int t = height[l];
                while (height[++l] <= t && l < r) ;
            } else {
                int t = height[r];
                while (height[--r] <= t && l < r) ;
            }
        }
        return maxarea;
    }


    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}