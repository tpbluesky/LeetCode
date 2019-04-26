package Problem128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 排完序一遍就可以找到答案，怎么不排序完成？
 * 基数排序O(n)
 */
class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int ans = 1, cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
                continue;
            }
            ans = cnt > ans ? cnt : ans;
            cnt = 1;
        }
        return ans;
    }

    public int longestConsecutive1(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int ans = 0;
        Iterator<Integer> itr = hs.iterator();
        while (itr.hasNext()) {
            Integer val = itr.next();
            int t = val + 1, cnt = 1;
            while (hs.contains(t)) {
                cnt++;
                t++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
