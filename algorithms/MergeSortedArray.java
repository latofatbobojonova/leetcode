//https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int[] nums3 = new int[m];
        int k = 0, j = 0;

        System.arraycopy(nums1, 0, nums3, 0, m);

        for (int i = 0; i < len; i++) {
            if (k >= m) {
                nums1[i] = nums2[j];
                j++;
                continue;
            }

            if (j >= n) {
                nums1[i] = nums3[k];
                k++;
                continue;
            }

            if (nums2[j] < nums3[k]) {
                nums1[i] = nums2[j];
                j++;
            } else {
                nums1[i] = nums3[k];
                k++;
            }
        }
    }
}
