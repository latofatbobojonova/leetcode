//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumberHigherOrLower {
    int guessedNumber = 5;

    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int mid;

        while (hi >= lo) {
            mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0)
                return mid;
            if (guess(mid) == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private int guess(int x) {
        if (x == guessedNumber)
            return 0;
        if (x < guessedNumber)
            return -1;
        return 1;
    }
}
