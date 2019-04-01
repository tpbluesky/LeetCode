package Problem4;

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



    public static void main(String args[]) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}