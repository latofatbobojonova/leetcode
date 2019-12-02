//https://leetcode.com/problems/remove-interval/

package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveInterval {
    public static void main(String[] args) {
        System.out.println(new RemoveInterval().removeInterval(new int[][]{{-5, -4}, {-3, -2}, {1, 2}, {3, 5}, {8, 9}}, new int[]{-1, 4}));
    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> leftRemovedIntervals = new LinkedList<>();
        List<List<Integer>> rightRemovedIntervals = new LinkedList<>();

        int len = intervals.length;

        int i = 0;
        while (i < len && intervals[i][1] < toBeRemoved[0]) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[i][0]);
            interval.add(intervals[i][1]);

            leftRemovedIntervals.add(interval);
            i++;
        }

        if (intervals[i][0] < toBeRemoved[0]) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[i][0]);
            interval.add(toBeRemoved[0]);

            leftRemovedIntervals.add(interval);
        }

        int j = len - 1;
        while (j >= 0 && intervals[j][0] > toBeRemoved[1]) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[j][0]);
            interval.add(intervals[j][1]);

            rightRemovedIntervals.add(0, interval);
            j--;
        }

        if (intervals[j][1] > toBeRemoved[1]) {
            List<Integer> interval = new ArrayList<>();
            interval.add(toBeRemoved[1]);
            interval.add(intervals[j][1]);

            rightRemovedIntervals.add(0, interval);
        }

        leftRemovedIntervals.addAll(rightRemovedIntervals);

        return leftRemovedIntervals;
    }
}
