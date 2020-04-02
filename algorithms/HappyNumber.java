//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {

        if (n <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int r = 0;

        while (true) {
            System.out.println(n);
            set.add(n);

            while (n != 0) {
                r = n % 10;
                sum += r * r;
                n /= 10;
            }
            n = sum;
            sum = 0;

            if (n == 1) {
                return true;
            } else if (set.contains(n)) {
                return false;
            }
        }
    }
}
