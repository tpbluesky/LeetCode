package Problem34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[]{-1, -1};
        int ans[] = new int[2];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }

        ans[0] = l >= 0 && l < nums.length && nums[l] == target ? l : -1;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] <= target) l = m + 1;
            else r = m - 1;
        }
        ans[1] = r >= 0 && r < nums.length && nums[r] == target ? r : -1;
        return ans;
    }
}