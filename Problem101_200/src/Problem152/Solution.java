package Problem152;

class Solution {
    public int maxProduct(int[] nums) {
        int max_p = 1, min_p = 1;
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int min_t = Math.min(Math.min(min_p * nums[i], max_p * nums[i]), nums[i]);
            max_p = Math.max(Math.max(min_p * nums[i], max_p * nums[i]), nums[i]);
            min_p = min_t;
            max_val = Math.max(max_val, max_p);
        }
        return max_val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
