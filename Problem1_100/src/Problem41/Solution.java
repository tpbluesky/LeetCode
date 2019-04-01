package Problem41;

import java.util.Scanner;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int lens = nums.length;
        for (int i = 0; i < lens; ++i) if (nums[i] < 1 || nums[i] > lens) nums[i] = 0;
        for (int i = 0; i < lens; ++i) {
            if (nums[i] != -1 && nums[i] != 0) {
                int t = nums[i];
                nums[i] = 0;
                while (t != 0 && t != -1) {
                    int k = nums[t - 1];
                    nums[t - 1] = -1;
                    t = k;
                }
            }
        }
        for (int i = 0; i < lens; ++i) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }
        return lens + 1;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        System.out.println(new Solution().firstMissingPositive(new int[]{1}));
    }
}