//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        int len = nums.length - 1;

        int mid;

        while (hi > lo) {
            mid = lo + (hi - lo) / 2;

            if (mid < len && nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[lo] > nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (lo == len + 1) return nums[0];
        return nums[hi];
    }
}
