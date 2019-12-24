//https://leetcode.com/problems/sqrtx/

public class SqrtX {
    public int mySqrt(int x) {
        double n = x;
        double err = 1e-15;
        while (Math.abs(n - x / n) > err * n) {
            n = (n + x / n) / 2.0;
        }
        return (int) n;
    }

    public int searchSqrt(int x) {
        if (x == 0)
            return 0;

        int hi = x;
        int lo = 1;
        int mid;

        while (hi >= lo) {
            mid = (hi - lo) / 2 + lo;

            if (mid == x / mid) return mid;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}
