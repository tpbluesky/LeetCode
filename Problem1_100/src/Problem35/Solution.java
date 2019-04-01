package Problem35;

class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}