package Problem16;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                int val = target - nums[i] - nums[j];
//                if (val < nums[j]) break;
                int pos = Arrays.binarySearch(nums, j + 1, nums.length, val);
                if (pos >= 0) return target;
                else {
                    int actualPos = -pos - 1;
//                    System.out.println(i + " " + j + " " + actualPos + " " + pos);
                    int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
                    if (actualPos - 1 > j) val1 = Math.abs(val - nums[actualPos - 1]);
                    if (actualPos < nums.length) val2 = Math.abs(val - nums[actualPos]);

                    if (ans > Math.min(val1, val2)) {
                        ans = Math.min(val1, val2);
                        sum = nums[i] + nums[j] + (val1 > val2 ? nums[actualPos] : nums[actualPos - 1]);
                    }
//                    System.out.println(i + " " + j + " " + val1 + " " + val2 + " " + ans + " " + nums[actualPos]);
                }
            }
        }
//        System.out.println(ans);
        return sum;
    }

    public static void main(String args[]) {
        Scanner sin = new Scanner(System.in);
        System.out.println(new Solution().threeSumClosest(new int[]{0, 1, 2}, 0));
    }
}