//https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(499979));
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int cntPrimes = 0;

        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                cntPrimes++;
                if ((long) i * i < n)
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
            }
        }

        return cntPrimes;
    }
}
