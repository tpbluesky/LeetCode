package Problem135;

/**
 * l2r[i] 代表从左往右严格递增的数的个数
 * r2l[i] 代表从右往左严格递增的数的个数
 * 那么第i个位置需要的糖的数量肯定是l2r[i]和r2l[i]中较大的那个值
 */
public class Solution {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int[] l2r = new int[ratings.length];
        int[] r2l = new int[ratings.length];
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                l2r[i] = l2r[i - 1] + 1;
            } else {
                l2r[i] = 0;
            }
        }
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                r2l[i] = r2l[i + 1] + 1;
            } else {
                r2l[i] = 0;
            }
        }
        int ans = ratings.length;
        for (int i = 0; i < ratings.length; ++i) {
            ans += Math.max(r2l[i], l2r[i]);
        }
        return ans;
    }

}
