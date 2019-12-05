//https://leetcode.com/problems/sqrtx/

package easy;

public class SqrtX {
    public int mySqrt(int x) {
        double n = x;
        double err = 1e-15;
        while (Math.abs(n - x / n) > err * n) {
            n = (n + x / n) / 2.0;
        }
        return (int) n;
    }
}
