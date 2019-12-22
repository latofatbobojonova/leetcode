//https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        while (x % 10 == 0) {
            x /= 10;
        }

        long reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }
}
