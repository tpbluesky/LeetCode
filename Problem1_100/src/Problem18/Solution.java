package Problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int sum2 = nums[i] + nums[j];
                int l = j + 1, r = len - 1;
                while (l < r) {
                    int t = nums[l] + nums[r];
                    if (sum2 + t == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        l++;
                        r--;
                        while (l < len && nums[l] == nums[l - 1]) l++;
                        while (r > j && nums[r] == nums[r + 1]) r--;
                        ans.add(list);
//                        System.out.println(Arrays.toString(list.toArray(new Integer[1])));
                    } else if (sum2 + t > target) r--;
                    else l++;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        List<List<Integer>> lists = new Solution().fourSum(new int[]{0, 0, 0, 0}, 0);
    }
}