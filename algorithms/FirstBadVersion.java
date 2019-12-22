//https://leetcode.com/problems/first-bad-version/

public class FirstBadVersion {
    /*
     This part is already implemented by leetcode
     Written only for tests
     */

    static int badStart = 5;

    public boolean isBadVersion(int n) {
        return n >= badStart;
    }

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid;

        while (hi > lo) {
            mid = (hi - lo) / 2 + lo;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
