package Problem81;

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (target == nums[m]) return true;
            if (nums[m] > nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else l = m + 1;
            } else if (nums[m] < nums[l]) {
                if (target > nums[m] && target < nums[l]) l = m + 1;
                else r = m - 1;
            } else {
                l++;
            }
        }
        return false;
    }
}
