package Problem75;

class Solution {
    public void sortColors(int[] nums) {
        int t0 = 0, t2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) t0++;
            else if (nums[i] == 2) t2++;
        }
        int len = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (i < t0) nums[i] = 0;
            else if (i >= len - t2) nums[i] = 2;
            else nums[i] = 1;
        }
    }
}
