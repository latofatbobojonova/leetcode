//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (hi >= lo) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[lo] == target)
                return lo;
            if (nums[hi] == target)
                return hi;

            if (nums[lo] < target && target < nums[mid] ||
                    target < nums[mid] && nums[mid] < nums[lo] && target < nums[hi] ||
                    target > nums[lo] && nums[lo] > nums[mid] && target > nums[hi]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
