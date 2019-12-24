//https://leetcode.com/problems/fibonacci-number/

public class FibonacciNumber {
    public int fib(int N) {
        int f1 = 1;
        int f2 = 0;

        for (int i = 1; i <= N; i++) {
            f2 = f2 + f1;
            f1 = f2 - f1;
        }

        return f2;
    }
}
