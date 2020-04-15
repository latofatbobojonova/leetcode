//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        int l = shift.length;
        int len = s.length();
        int toTheLeft = 0;

        for (int i = 0; i < l; i++) {
            if (shift[i][0] == 0) {
                toTheLeft += shift[i][1];
            } else {
                toTheLeft -= shift[i][1];
            }
        }

        String ans;
        toTheLeft = toTheLeft % len;

        if (toTheLeft > 0) {
            ans = s.substring(toTheLeft) + s.substring(0, toTheLeft);
        } else if (toTheLeft < 0) {
            ans = s.substring(len + toTheLeft) + s.substring(0, len + toTheLeft);
        } else {
            ans = s;
        }

        return ans;
    }
}
