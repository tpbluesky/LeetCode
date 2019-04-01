package Problem53;

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[0] = Math.max(nums[i], nums[i] + nums[0]);
            ans = Math.max(nums[0], ans);
        }
        return ans;
    }
}
