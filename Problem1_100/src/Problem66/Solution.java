package Problem66;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int lens = digits.length;
        int ans[] = new int[lens + 1];
        int pre = 1;
        for (int i = lens - 1; i >= 0; i--) {
            int t = pre + digits[i];
            ans[i + 1] = t % 10;
            pre = t / 10;
        }
        ans[0] = pre;
        System.out.println(Arrays.toString(ans));
        return ans[0] == 0 ? Arrays.copyOfRange(ans, 1, lens) : ans;
    }
}
