//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int lo = 0;
        int hi = nums.length - 1;
        int len = hi;
        int mid;
        int targetStart = -1;
        int targetEnd = -1;

        // Search for targetStart
        while (hi > lo + 1) {
            mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid - 1] != target) {
                    targetStart = mid;
                    break;
                } else {
                    hi = mid;
                }
            } else {
                if (nums[mid] > target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
        }

        if (targetStart == -1 && target == nums[lo]) {
            targetStart = lo;
        } else if (targetStart == -1 && target == nums[hi]) {
            targetStart = hi;
        }

        lo = 0;
        hi = len;
        // Search for targetEnd
        while (hi > lo + 1) {
            mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                if (mid == len || nums[mid + 1] != target) {
                    targetEnd = mid;
                    break;
                } else {
                    lo = mid;
                }
            } else {
                if (nums[mid] > target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
        }

        if (targetEnd == -1 && target == nums[hi]) {
            targetEnd = hi;
        } else if (targetEnd == -1 && target == nums[lo]) {
            targetEnd = lo;
        }

        return new int[]{targetStart, targetEnd};
    }
}
