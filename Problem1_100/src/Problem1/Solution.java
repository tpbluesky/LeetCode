package Problem1;

import java.util.HashMap;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		int n = nums.length;
		int[] ans = new int[2];
		for (int i = 0; i < n; ++i) {
			if (mp.containsKey(target - nums[i])) {
				ans[0] = mp.get(target - nums[i]);
				ans[1] = i;
				break;
			}
			mp.put(nums[i], i);
		}
		return ans;
	}
}