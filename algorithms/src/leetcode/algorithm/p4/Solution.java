package leetcode.algorithm.p4;

/**
 * p4: https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * @author xinquan.huangxq
 */
public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("illegal argument");
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        if (length % 2 != 0) {
            return findLastKNum(nums1, 0, length1, nums2, 0, length2, length / 2 + 1);
        } else {
            return (findLastKNum(nums1, 0, length1, nums2, 0, length2, length / 2) +
                    findLastKNum(nums1, 0, length1, nums2, 0, length2, length / 2 + 1)) / 2;
        }
    }

    public static double findLastKNum(int[] nums1, int i1, int length1, int[] nums2, int i2, int length2, int k) {
        if (length1 > length2) {
            return findLastKNum(nums2, i2, length2, nums1, i1, length1, k);
        }
        if (length1 == 0) {
            return nums2[i2 + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[i1], nums2[i2]);
        } else {
            int p1 = Math.min(k / 2, length1);
            int p2 = k - p1;
            if (nums1[i1 + p1 - 1] < nums2[i2 + p2 - 1]) {
                return findLastKNum(nums1, i1 + p1, length1 - p1, nums2, i2, length2, k - p1);
            } else if (nums1[i1 + p1 - 1] > nums2[i2 + p2 - 1]) {
                return findLastKNum(nums1, i1, length1, nums2, i2 + p2, length2 - p2, k - p2);
            } else {
                return nums1[i1 + p1 - 1];
            }
        }
    }
}
