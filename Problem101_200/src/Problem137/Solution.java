package Problem137;

public class Solution {
    public int singleNumber1(int[] nums) {
        int res = 0;
        for (int j = 0; j < 32; j++) {
            int cnt = 0;
            for (int i = 0; i < nums.length; ++i) {
                cnt += (nums[i] & (1 << j)) == 0 ? 0 : 1;
            }
            if ((cnt % 3) != 0) {
                res |= (1 << j);
            }
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            a = a ^ nums[i] & ~b;
            b = b ^ nums[i] & ~a;
        }
        return a | b;
    }

}