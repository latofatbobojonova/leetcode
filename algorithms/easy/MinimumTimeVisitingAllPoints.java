//https://leetcode.com/problems/minimum-time-visiting-all-points/

package easy;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        int len = points.length;
        for (int i = 0; i < len - 1; i++) {
            minTime += max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return minTime;
    }

    private int max(int a, int b) {
        return (a < b) ? b : a;
    }
}
