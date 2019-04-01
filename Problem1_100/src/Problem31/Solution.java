package Problem31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int lens = nums.length;
        int p1 = -1, p2 = -1;
        for (int i = 0; i < lens; ++i) {
            for (int j = i + 1; j < lens; ++j) {
                if (nums[i] < nums[j]) {
                    p1 = i;
                    p2 = j;
                }
            }
        }
        if(p1 == -1){
            Arrays.sort(nums);
            return;
        }
        int t = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = t;
        int l = p2 + 1, r = lens - 1;
        Arrays.sort(nums, p1+1, lens);
    }
}