package Problem45;


class Solution {

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int ans = 0;
        int maxIdx = 0;
        int t = maxIdx + nums[maxIdx];
        while (t < nums.length - 1) {
            System.out.println("===" + maxIdx);
            for (int i = maxIdx + 1; i <= t && i < nums.length; ++i) {
                System.out.println(i + nums[i]);
                if (i + nums[i] > maxIdx + nums[maxIdx]) maxIdx = i;
            }
            t = maxIdx + nums[maxIdx];
            ans++;
        }
        return ans + 1;
    }
}