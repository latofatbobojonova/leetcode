//https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> kClosest = new ArrayList<>();
        int n = arr.length - 1;
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                kClosest.add(arr[i]);
            }
            return kClosest;
        }

        if (x > arr[n]) {
            for (int i = n - k; i <= n; i++) {
                kClosest.add(arr[i]);
            }
            return kClosest;
        }

        int ind = lowerBound(arr, x);
        int lo = (ind > k) ? ind - k : 0;
        int hi = (ind + k > n) ? n : ind + k;

        while (hi - lo != k - 1) {

            if (arr[hi] - x < x - arr[lo]) {
                lo++;
            } else {
                hi--;
            }
        }

        for (int i = lo; i <= hi; i++) {
            kClosest.add(arr[i]);
        }

        return kClosest;
    }

    private int lowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (lo != 0) return lo - 1;
        return lo;
    }
}
