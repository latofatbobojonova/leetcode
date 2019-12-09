package easy;

public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int d;
        int sum = 0;
        int prod = 1;
        while (n != 0) {
            d = n % 10;
            sum += d;
            prod *= d;
            n /= 10;
        }

        return prod - sum;
    }
}
