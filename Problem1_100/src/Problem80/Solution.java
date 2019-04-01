package Problem80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0, k = 1, i = 0;
        while (i < nums.length) {
            int t = nums[i++];
            while (i < nums.length && nums[i] == t){i++; k++;}
            for (int j = 0; j < Math.min(k, 2); j++) {
                nums[cnt++] = t;
            }
            k = 1;
        }
        return cnt;
    }
}
