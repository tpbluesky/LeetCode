package Problem27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        for (int j = 0; j < len; ++j) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}