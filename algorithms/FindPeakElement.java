//https://leetcode.com/problems/find-peak-element/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int len = nums.length - 1;
        int hi = len;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (mid < len && nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (hi == nums.length) return hi - 1;
        return hi;
    }
}
