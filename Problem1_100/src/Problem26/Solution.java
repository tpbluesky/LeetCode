package Problem26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int lens = nums.length;
        if (lens <= 0) return lens;
        int t = 1;
        for (int i = 1; i < lens; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[t++] = nums[i];
        }
        return t;
    }

}