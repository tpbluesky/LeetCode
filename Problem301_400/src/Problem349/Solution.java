package Problem349;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        for (int x : nums1) a.add(x);
        for (int x : nums2) b.add(x);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer x : b) if (a.contains(x)) res.add(x);
        int ans[] = new int[res.size()];
        for (int i = 0; i < ans.length; ++i) ans[i] = res.get(i);
        return ans;
    }
}
