package Problem4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k = (len1 + len2 + 1) / 2;

        int val1 = 0, val2 = 0;

        int idx = 0, i = 0, j = 0;
        while (i < len1 && j < len2) {
            idx++;
            if (nums1[i] < nums2[j]) {
                if (idx == k) {
                    val1 = nums1[i];
                }
                if (idx == k + 1) {
                    val2 = nums1[i];
                    break;
                }
                i++;
            } else {
                if (idx == k) {
                    val1 = nums2[j];
                }
                if (idx == k + 1) {
                    val2 = nums2[j];
                    break;
                }
                j++;
            }
        }
        while (i < len1) {
            idx++;
            if (idx == k) {
                val1 = nums1[i];
            }
            if (idx == k + 1) {
                val2 = nums1[i];
                break;
            }
            i++;
        }
        while (j < len2) {
            idx++;
            if (idx == k) {
                val1 = nums2[j];
            }
            if (idx == k + 1) {
                val2 = nums2[j];
                break;
            }
            j++;
        }
        return (len1 + len2) % 2 == 1 ? val1 : (val1 + val2) / 2.0;
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        return help(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, size / 2);

    }

    public static double help(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2, int k) {
        if (k == 0) {
            int size = nums1.length + nums2.length;
            if (size % 2 == 1) return Math.min(nums1[l1], nums2[l2]);
            return (nums1[l1] + nums2[l2]) / 2.0;
        }
        double mid1 = (r1 - l1 + 1) % 2 == 0 ? (nums1[(r1 + l1) / 2] + nums1[(r1 + l1) / 2 + 1]) / 2.0 : nums1[(r1 + l1) / 2];
        double mid2 = (r2 - l2 + 1) % 2 == 0 ? (nums2[(r2 + l2) / 2] + nums2[(r2 + l2) / 2 + 1]) / 2.0 : nums2[(r2 + l2) / 2];
        if (mid1 == mid2) return mid1;
        if (mid1 < mid2) {
        } else {
        }
        return 0;
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {3};
        System.out.println(new Solution().findMedianSortedArrays1(nums1, nums2));
    }
}