//https://leetcode.com/problems/binary-search/

public class BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (hi >= lo) {
            mid = (hi + lo) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
